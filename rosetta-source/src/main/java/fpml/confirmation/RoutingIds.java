package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.RoutingId;
import fpml.confirmation.RoutingIds;
import fpml.confirmation.RoutingIds.RoutingIdsBuilder;
import fpml.confirmation.RoutingIds.RoutingIdsBuilderImpl;
import fpml.confirmation.RoutingIds.RoutingIdsImpl;
import fpml.confirmation.meta.RoutingIdsMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type that provides for identifying a party involved in the routing of a payment by means of one or more standard identification codes. For example, both a SWIFT BIC code and a national bank identifier may be required.
 * @version ${project.version}
 */
@RosettaDataType(value="RoutingIds", builder=RoutingIds.RoutingIdsBuilderImpl.class, version="${project.version}")
public interface RoutingIds extends RosettaModelObject {

	RoutingIdsMeta metaData = new RoutingIdsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A unique identifier for party that is a participant in a recognized payment system.
	 */
	List<? extends RoutingId> getRoutingId();

	/*********************** Build Methods  ***********************/
	RoutingIds build();
	
	RoutingIds.RoutingIdsBuilder toBuilder();
	
	static RoutingIds.RoutingIdsBuilder builder() {
		return new RoutingIds.RoutingIdsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RoutingIds> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RoutingIds> getType() {
		return RoutingIds.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("routingId"), processor, RoutingId.class, getRoutingId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RoutingIdsBuilder extends RoutingIds, RosettaModelObjectBuilder {
		RoutingId.RoutingIdBuilder getOrCreateRoutingId(int _index);
		List<? extends RoutingId.RoutingIdBuilder> getRoutingId();
		RoutingIds.RoutingIdsBuilder addRoutingId(RoutingId routingId0);
		RoutingIds.RoutingIdsBuilder addRoutingId(RoutingId routingId1, int _idx);
		RoutingIds.RoutingIdsBuilder addRoutingId(List<? extends RoutingId> routingId2);
		RoutingIds.RoutingIdsBuilder setRoutingId(List<? extends RoutingId> routingId3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("routingId"), processor, RoutingId.RoutingIdBuilder.class, getRoutingId());
		}
		

		RoutingIds.RoutingIdsBuilder prune();
	}

	/*********************** Immutable Implementation of RoutingIds  ***********************/
	class RoutingIdsImpl implements RoutingIds {
		private final List<? extends RoutingId> routingId;
		
		protected RoutingIdsImpl(RoutingIds.RoutingIdsBuilder builder) {
			this.routingId = ofNullable(builder.getRoutingId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("routingId")
		public List<? extends RoutingId> getRoutingId() {
			return routingId;
		}
		
		@Override
		public RoutingIds build() {
			return this;
		}
		
		@Override
		public RoutingIds.RoutingIdsBuilder toBuilder() {
			RoutingIds.RoutingIdsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RoutingIds.RoutingIdsBuilder builder) {
			ofNullable(getRoutingId()).ifPresent(builder::setRoutingId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RoutingIds _that = getType().cast(o);
		
			if (!ListEquals.listEquals(routingId, _that.getRoutingId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingId != null ? routingId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RoutingIds {" +
				"routingId=" + this.routingId +
			'}';
		}
	}

	/*********************** Builder Implementation of RoutingIds  ***********************/
	class RoutingIdsBuilderImpl implements RoutingIds.RoutingIdsBuilder {
	
		protected List<RoutingId.RoutingIdBuilder> routingId = new ArrayList<>();
	
		public RoutingIdsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("routingId")
		public List<? extends RoutingId.RoutingIdBuilder> getRoutingId() {
			return routingId;
		}
		
		@Override
		public RoutingId.RoutingIdBuilder getOrCreateRoutingId(int _index) {
		
			if (routingId==null) {
				this.routingId = new ArrayList<>();
			}
			RoutingId.RoutingIdBuilder result;
			return getIndex(routingId, _index, () -> {
						RoutingId.RoutingIdBuilder newRoutingId = RoutingId.builder();
						return newRoutingId;
					});
		}
		
		@Override
		@RosettaAttribute("routingId")
		public RoutingIds.RoutingIdsBuilder addRoutingId(RoutingId routingId) {
			if (routingId!=null) this.routingId.add(routingId.toBuilder());
			return this;
		}
		
		@Override
		public RoutingIds.RoutingIdsBuilder addRoutingId(RoutingId routingId, int _idx) {
			getIndex(this.routingId, _idx, () -> routingId.toBuilder());
			return this;
		}
		@Override 
		public RoutingIds.RoutingIdsBuilder addRoutingId(List<? extends RoutingId> routingIds) {
			if (routingIds != null) {
				for (RoutingId toAdd : routingIds) {
					this.routingId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public RoutingIds.RoutingIdsBuilder setRoutingId(List<? extends RoutingId> routingIds) {
			if (routingIds == null)  {
				this.routingId = new ArrayList<>();
			}
			else {
				this.routingId = routingIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public RoutingIds build() {
			return new RoutingIds.RoutingIdsImpl(this);
		}
		
		@Override
		public RoutingIds.RoutingIdsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RoutingIds.RoutingIdsBuilder prune() {
			routingId = routingId.stream().filter(b->b!=null).<RoutingId.RoutingIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRoutingId()!=null && getRoutingId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RoutingIds.RoutingIdsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RoutingIds.RoutingIdsBuilder o = (RoutingIds.RoutingIdsBuilder) other;
			
			merger.mergeRosetta(getRoutingId(), o.getRoutingId(), this::getOrCreateRoutingId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RoutingIds _that = getType().cast(o);
		
			if (!ListEquals.listEquals(routingId, _that.getRoutingId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingId != null ? routingId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RoutingIdsBuilder {" +
				"routingId=" + this.routingId +
			'}';
		}
	}
}
