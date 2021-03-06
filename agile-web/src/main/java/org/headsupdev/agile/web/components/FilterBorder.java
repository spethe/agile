/*
 * HeadsUp Agile
 * Copyright 2009-2012 Heads Up Development Ltd.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.headsupdev.agile.web.components;

import org.apache.wicket.markup.html.border.Border;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.wicketstuff.animator.Animator;
import org.wicketstuff.animator.MarkupIdModel;
import org.wicketstuff.animator.IAnimatorSubject;

/**
 * TODO Document me!
 *
 * @author Andrew Williams
 * @version $Id$
 * @since 1.0
 */
public class FilterBorder
    extends Border
{
    public FilterBorder( String id )
    {
        super( id );

        WebMarkupContainer filter = new WebMarkupContainer( "filter" );
        filter.setMarkupId( "filter" );
        add( filter );

        WebMarkupContainer filterButton = new WebMarkupContainer( "filterbutton" );
        filterButton.setMarkupId( "filterbutton" );
        add( filterButton );

        Animator animator = new Animator();
        animator.addCssStyleSubject( new MarkupIdModel( filter ), "filterhidden", "filtershown" );
        animator.addCssStyleSubject( new MarkupIdModel( filterButton ), "filterbuttonhidden", "filterbuttonshown" );
        animator.attachTo( filterButton, "onclick", Animator.Action.toggle() );
        animator.addSubject( new IAnimatorSubject()
        {
            public String getJavaScript()
            {
                return "moveFilterButtonBackground";
            }
        } );

        filter.add( getBodyContainer() );
    }
}
