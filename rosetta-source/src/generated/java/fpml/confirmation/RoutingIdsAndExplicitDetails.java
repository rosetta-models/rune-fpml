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
import fpml.confirmation.RoutingExplicitDetailsModel;
import fpml.confirmation.RoutingIds;
import fpml.confirmation.RoutingIdsAndExplicitDetails;
import fpml.confirmation.RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder;
import fpml.confirmation.RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilderImpl;
import fpml.confirmation.RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsImpl;
import fpml.confirmation.meta.RoutingIdsAndExplicitDetailsMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type that provides a combination of payment system identification codes with physical postal address details, for the purposes of identifying a party involved in the routing of a payment.
 * @version ${project.version}
 */
@RosettaDataType(value="RoutingIdsAndExplicitDetails", builder=RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilderImpl.class, version="${project.version}")
public interface RoutingIdsAndExplicitDetails extends RosettaModelObject {

	RoutingIdsAndExplicitDetailsMeta metaData = new RoutingIdsAndExplicitDetailsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A set of unique identifiers for a party, eachone identifying the party within a payment system. The assumption is that each party will not have more than one identifier within the same payment system.
	 */
	List<? extends RoutingIds> getRoutingIds();
	RoutingExplicitDetailsModel getRoutingExplicitDetailsModel();

	/*********************** Build Methods  ***********************/
	RoutingIdsAndExplicitDetails build();
	
	RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder toBuilder();
	
	static RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder builder() {
		return new RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RoutingIdsAndExplicitDetails> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RoutingIdsAndExplicitDetails> getType() {
		return RoutingIdsAndExplicitDetails.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("routingIds"), processor, RoutingIds.class, getRoutingIds());
		processRosetta(path.newSubPath("routingExplicitDetailsModel"), processor, RoutingExplicitDetailsModel.class, getRoutingExplicitDetailsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RoutingIdsAndExplicitDetailsBuilder extends RoutingIdsAndExplicitDetails, RosettaModelObjectBuilder {
		RoutingIds.RoutingIdsBuilder getOrCreateRoutingIds(int _index);
		List<? extends RoutingIds.RoutingIdsBuilder> getRoutingIds();
		RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder getOrCreateRoutingExplicitDetailsModel();
		RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder getRoutingExplicitDetailsModel();
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder addRoutingIds(RoutingIds routingIds0);
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder addRoutingIds(RoutingIds routingIds1, int _idx);
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder addRoutingIds(List<? extends RoutingIds> routingIds2);
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder setRoutingIds(List<? extends RoutingIds> routingIds3);
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder setRoutingExplicitDetailsModel(RoutingExplicitDetailsModel routingExplicitDetailsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("routingIds"), processor, RoutingIds.RoutingIdsBuilder.class, getRoutingIds());
			processRosetta(path.newSubPath("routingExplicitDetailsModel"), processor, RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder.class, getRoutingExplicitDetailsModel());
		}
		

		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of RoutingIdsAndExplicitDetails  ***********************/
	class RoutingIdsAndExplicitDetailsImpl implements RoutingIdsAndExplicitDetails {
		private final List<? extends RoutingIds> routingIds;
		private final RoutingExplicitDetailsModel routingExplicitDetailsModel;
		
		protected RoutingIdsAndExplicitDetailsImpl(RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder builder) {
			this.routingIds = ofNullable(builder.getRoutingIds()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.routingExplicitDetailsModel = ofNullable(builder.getRoutingExplicitDetailsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("routingIds")
		public List<? extends RoutingIds> getRoutingIds() {
			return routingIds;
		}
		
		@Override
		@RosettaAttribute("routingExplicitDetailsModel")
		public RoutingExplicitDetailsModel getRoutingExplicitDetailsModel() {
			return routingExplicitDetailsModel;
		}
		
		@Override
		public RoutingIdsAndExplicitDetails build() {
			return this;
		}
		
		@Override
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder toBuilder() {
			RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder builder) {
			ofNullable(getRoutingIds()).ifPresent(builder::setRoutingIds);
			ofNullable(getRoutingExplicitDetailsModel()).ifPresent(builder::setRoutingExplicitDetailsModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RoutingIdsAndExplicitDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(routingIds, _that.getRoutingIds())) return false;
			if (!Objects.equals(routingExplicitDetailsModel, _that.getRoutingExplicitDetailsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingIds != null ? routingIds.hashCode() : 0);
			_result = 31 * _result + (routingExplicitDetailsModel != null ? routingExplicitDetailsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RoutingIdsAndExplicitDetails {" +
				"routingIds=" + this.routingIds + ", " +
				"routingExplicitDetailsModel=" + this.routingExplicitDetailsModel +
			'}';
		}
	}

	/*********************** Builder Implementation of RoutingIdsAndExplicitDetails  ***********************/
	class RoutingIdsAndExplicitDetailsBuilderImpl implements RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder {
	
		protected List<RoutingIds.RoutingIdsBuilder> routingIds = new ArrayList<>();
		protected RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder routingExplicitDetailsModel;
	
		public RoutingIdsAndExplicitDetailsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("routingIds")
		public List<? extends RoutingIds.RoutingIdsBuilder> getRoutingIds() {
			return routingIds;
		}
		
		public RoutingIds.RoutingIdsBuilder getOrCreateRoutingIds(int _index) {
		
			if (routingIds==null) {
				this.routingIds = new ArrayList<>();
			}
			RoutingIds.RoutingIdsBuilder result;
			return getIndex(routingIds, _index, () -> {
						RoutingIds.RoutingIdsBuilder newRoutingIds = RoutingIds.builder();
						return newRoutingIds;
					});
		}
		
		@Override
		@RosettaAttribute("routingExplicitDetailsModel")
		public RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder getRoutingExplicitDetailsModel() {
			return routingExplicitDetailsModel;
		}
		
		@Override
		public RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder getOrCreateRoutingExplicitDetailsModel() {
			RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder result;
			if (routingExplicitDetailsModel!=null) {
				result = routingExplicitDetailsModel;
			}
			else {
				result = routingExplicitDetailsModel = RoutingExplicitDetailsModel.builder();
			}
			
			return result;
		}
		
		@Override
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder addRoutingIds(RoutingIds routingIds) {
			if (routingIds!=null) this.routingIds.add(routingIds.toBuilder());
			return this;
		}
		
		@Override
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder addRoutingIds(RoutingIds routingIds, int _idx) {
			getIndex(this.routingIds, _idx, () -> routingIds.toBuilder());
			return this;
		}
		@Override 
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder addRoutingIds(List<? extends RoutingIds> routingIdss) {
			if (routingIdss != null) {
				for (RoutingIds toAdd : routingIdss) {
					this.routingIds.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("routingIds")
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder setRoutingIds(List<? extends RoutingIds> routingIdss) {
			if (routingIdss == null)  {
				this.routingIds = new ArrayList<>();
			}
			else {
				this.routingIds = routingIdss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("routingExplicitDetailsModel")
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder setRoutingExplicitDetailsModel(RoutingExplicitDetailsModel routingExplicitDetailsModel) {
			this.routingExplicitDetailsModel = routingExplicitDetailsModel==null?null:routingExplicitDetailsModel.toBuilder();
			return this;
		}
		
		@Override
		public RoutingIdsAndExplicitDetails build() {
			return new RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsImpl(this);
		}
		
		@Override
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder prune() {
			routingIds = routingIds.stream().filter(b->b!=null).<RoutingIds.RoutingIdsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (routingExplicitDetailsModel!=null && !routingExplicitDetailsModel.prune().hasData()) routingExplicitDetailsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRoutingIds()!=null && getRoutingIds().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRoutingExplicitDetailsModel()!=null && getRoutingExplicitDetailsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder o = (RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder) other;
			
			merger.mergeRosetta(getRoutingIds(), o.getRoutingIds(), this::getOrCreateRoutingIds);
			merger.mergeRosetta(getRoutingExplicitDetailsModel(), o.getRoutingExplicitDetailsModel(), this::setRoutingExplicitDetailsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RoutingIdsAndExplicitDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(routingIds, _that.getRoutingIds())) return false;
			if (!Objects.equals(routingExplicitDetailsModel, _that.getRoutingExplicitDetailsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingIds != null ? routingIds.hashCode() : 0);
			_result = 31 * _result + (routingExplicitDetailsModel != null ? routingExplicitDetailsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RoutingIdsAndExplicitDetailsBuilder {" +
				"routingIds=" + this.routingIds + ", " +
				"routingExplicitDetailsModel=" + this.routingExplicitDetailsModel +
			'}';
		}
	}
}
