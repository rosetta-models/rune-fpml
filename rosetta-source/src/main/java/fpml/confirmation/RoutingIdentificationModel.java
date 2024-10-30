package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.RoutingExplicitDetails;
import fpml.confirmation.RoutingIdentificationModel;
import fpml.confirmation.RoutingIdentificationModel.RoutingIdentificationModelBuilder;
import fpml.confirmation.RoutingIdentificationModel.RoutingIdentificationModelBuilderImpl;
import fpml.confirmation.RoutingIdentificationModel.RoutingIdentificationModelImpl;
import fpml.confirmation.RoutingIds;
import fpml.confirmation.RoutingIdsAndExplicitDetails;
import fpml.confirmation.meta.RoutingIdentificationModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="RoutingIdentificationModel", builder=RoutingIdentificationModel.RoutingIdentificationModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface RoutingIdentificationModel extends RosettaModelObject {

	RoutingIdentificationModelMeta metaData = new RoutingIdentificationModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A set of unique identifiers for a party, eachone identifying the party within a payment system. The assumption is that each party will not have more than one identifier within the same payment system.
	 */
	RoutingIds getRoutingIds();
	/**
	 * A set of details that is used to identify a party involved in the routing of a payment when the party does not have a code that identifies it within one of the recognized payment systems.
	 */
	RoutingExplicitDetails getRoutingExplicitDetails();
	/**
	 * A combination of coded payment system identifiers and details for physical addressing for a party involved in the routing of a payment.
	 */
	RoutingIdsAndExplicitDetails getRoutingIdsAndExplicitDetails();

	/*********************** Build Methods  ***********************/
	RoutingIdentificationModel build();
	
	RoutingIdentificationModel.RoutingIdentificationModelBuilder toBuilder();
	
	static RoutingIdentificationModel.RoutingIdentificationModelBuilder builder() {
		return new RoutingIdentificationModel.RoutingIdentificationModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RoutingIdentificationModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RoutingIdentificationModel> getType() {
		return RoutingIdentificationModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("routingIds"), processor, RoutingIds.class, getRoutingIds());
		processRosetta(path.newSubPath("routingExplicitDetails"), processor, RoutingExplicitDetails.class, getRoutingExplicitDetails());
		processRosetta(path.newSubPath("routingIdsAndExplicitDetails"), processor, RoutingIdsAndExplicitDetails.class, getRoutingIdsAndExplicitDetails());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RoutingIdentificationModelBuilder extends RoutingIdentificationModel, RosettaModelObjectBuilder {
		RoutingIds.RoutingIdsBuilder getOrCreateRoutingIds();
		RoutingIds.RoutingIdsBuilder getRoutingIds();
		RoutingExplicitDetails.RoutingExplicitDetailsBuilder getOrCreateRoutingExplicitDetails();
		RoutingExplicitDetails.RoutingExplicitDetailsBuilder getRoutingExplicitDetails();
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder getOrCreateRoutingIdsAndExplicitDetails();
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder getRoutingIdsAndExplicitDetails();
		RoutingIdentificationModel.RoutingIdentificationModelBuilder setRoutingIds(RoutingIds routingIds);
		RoutingIdentificationModel.RoutingIdentificationModelBuilder setRoutingExplicitDetails(RoutingExplicitDetails routingExplicitDetails);
		RoutingIdentificationModel.RoutingIdentificationModelBuilder setRoutingIdsAndExplicitDetails(RoutingIdsAndExplicitDetails routingIdsAndExplicitDetails);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("routingIds"), processor, RoutingIds.RoutingIdsBuilder.class, getRoutingIds());
			processRosetta(path.newSubPath("routingExplicitDetails"), processor, RoutingExplicitDetails.RoutingExplicitDetailsBuilder.class, getRoutingExplicitDetails());
			processRosetta(path.newSubPath("routingIdsAndExplicitDetails"), processor, RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder.class, getRoutingIdsAndExplicitDetails());
		}
		

		RoutingIdentificationModel.RoutingIdentificationModelBuilder prune();
	}

	/*********************** Immutable Implementation of RoutingIdentificationModel  ***********************/
	class RoutingIdentificationModelImpl implements RoutingIdentificationModel {
		private final RoutingIds routingIds;
		private final RoutingExplicitDetails routingExplicitDetails;
		private final RoutingIdsAndExplicitDetails routingIdsAndExplicitDetails;
		
		protected RoutingIdentificationModelImpl(RoutingIdentificationModel.RoutingIdentificationModelBuilder builder) {
			this.routingIds = ofNullable(builder.getRoutingIds()).map(f->f.build()).orElse(null);
			this.routingExplicitDetails = ofNullable(builder.getRoutingExplicitDetails()).map(f->f.build()).orElse(null);
			this.routingIdsAndExplicitDetails = ofNullable(builder.getRoutingIdsAndExplicitDetails()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("routingIds")
		public RoutingIds getRoutingIds() {
			return routingIds;
		}
		
		@Override
		@RosettaAttribute("routingExplicitDetails")
		public RoutingExplicitDetails getRoutingExplicitDetails() {
			return routingExplicitDetails;
		}
		
		@Override
		@RosettaAttribute("routingIdsAndExplicitDetails")
		public RoutingIdsAndExplicitDetails getRoutingIdsAndExplicitDetails() {
			return routingIdsAndExplicitDetails;
		}
		
		@Override
		public RoutingIdentificationModel build() {
			return this;
		}
		
		@Override
		public RoutingIdentificationModel.RoutingIdentificationModelBuilder toBuilder() {
			RoutingIdentificationModel.RoutingIdentificationModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RoutingIdentificationModel.RoutingIdentificationModelBuilder builder) {
			ofNullable(getRoutingIds()).ifPresent(builder::setRoutingIds);
			ofNullable(getRoutingExplicitDetails()).ifPresent(builder::setRoutingExplicitDetails);
			ofNullable(getRoutingIdsAndExplicitDetails()).ifPresent(builder::setRoutingIdsAndExplicitDetails);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RoutingIdentificationModel _that = getType().cast(o);
		
			if (!Objects.equals(routingIds, _that.getRoutingIds())) return false;
			if (!Objects.equals(routingExplicitDetails, _that.getRoutingExplicitDetails())) return false;
			if (!Objects.equals(routingIdsAndExplicitDetails, _that.getRoutingIdsAndExplicitDetails())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingIds != null ? routingIds.hashCode() : 0);
			_result = 31 * _result + (routingExplicitDetails != null ? routingExplicitDetails.hashCode() : 0);
			_result = 31 * _result + (routingIdsAndExplicitDetails != null ? routingIdsAndExplicitDetails.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RoutingIdentificationModel {" +
				"routingIds=" + this.routingIds + ", " +
				"routingExplicitDetails=" + this.routingExplicitDetails + ", " +
				"routingIdsAndExplicitDetails=" + this.routingIdsAndExplicitDetails +
			'}';
		}
	}

	/*********************** Builder Implementation of RoutingIdentificationModel  ***********************/
	class RoutingIdentificationModelBuilderImpl implements RoutingIdentificationModel.RoutingIdentificationModelBuilder {
	
		protected RoutingIds.RoutingIdsBuilder routingIds;
		protected RoutingExplicitDetails.RoutingExplicitDetailsBuilder routingExplicitDetails;
		protected RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder routingIdsAndExplicitDetails;
	
		public RoutingIdentificationModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("routingIds")
		public RoutingIds.RoutingIdsBuilder getRoutingIds() {
			return routingIds;
		}
		
		@Override
		public RoutingIds.RoutingIdsBuilder getOrCreateRoutingIds() {
			RoutingIds.RoutingIdsBuilder result;
			if (routingIds!=null) {
				result = routingIds;
			}
			else {
				result = routingIds = RoutingIds.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("routingExplicitDetails")
		public RoutingExplicitDetails.RoutingExplicitDetailsBuilder getRoutingExplicitDetails() {
			return routingExplicitDetails;
		}
		
		@Override
		public RoutingExplicitDetails.RoutingExplicitDetailsBuilder getOrCreateRoutingExplicitDetails() {
			RoutingExplicitDetails.RoutingExplicitDetailsBuilder result;
			if (routingExplicitDetails!=null) {
				result = routingExplicitDetails;
			}
			else {
				result = routingExplicitDetails = RoutingExplicitDetails.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("routingIdsAndExplicitDetails")
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder getRoutingIdsAndExplicitDetails() {
			return routingIdsAndExplicitDetails;
		}
		
		@Override
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder getOrCreateRoutingIdsAndExplicitDetails() {
			RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder result;
			if (routingIdsAndExplicitDetails!=null) {
				result = routingIdsAndExplicitDetails;
			}
			else {
				result = routingIdsAndExplicitDetails = RoutingIdsAndExplicitDetails.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("routingIds")
		public RoutingIdentificationModel.RoutingIdentificationModelBuilder setRoutingIds(RoutingIds routingIds) {
			this.routingIds = routingIds==null?null:routingIds.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("routingExplicitDetails")
		public RoutingIdentificationModel.RoutingIdentificationModelBuilder setRoutingExplicitDetails(RoutingExplicitDetails routingExplicitDetails) {
			this.routingExplicitDetails = routingExplicitDetails==null?null:routingExplicitDetails.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("routingIdsAndExplicitDetails")
		public RoutingIdentificationModel.RoutingIdentificationModelBuilder setRoutingIdsAndExplicitDetails(RoutingIdsAndExplicitDetails routingIdsAndExplicitDetails) {
			this.routingIdsAndExplicitDetails = routingIdsAndExplicitDetails==null?null:routingIdsAndExplicitDetails.toBuilder();
			return this;
		}
		
		@Override
		public RoutingIdentificationModel build() {
			return new RoutingIdentificationModel.RoutingIdentificationModelImpl(this);
		}
		
		@Override
		public RoutingIdentificationModel.RoutingIdentificationModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RoutingIdentificationModel.RoutingIdentificationModelBuilder prune() {
			if (routingIds!=null && !routingIds.prune().hasData()) routingIds = null;
			if (routingExplicitDetails!=null && !routingExplicitDetails.prune().hasData()) routingExplicitDetails = null;
			if (routingIdsAndExplicitDetails!=null && !routingIdsAndExplicitDetails.prune().hasData()) routingIdsAndExplicitDetails = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRoutingIds()!=null && getRoutingIds().hasData()) return true;
			if (getRoutingExplicitDetails()!=null && getRoutingExplicitDetails().hasData()) return true;
			if (getRoutingIdsAndExplicitDetails()!=null && getRoutingIdsAndExplicitDetails().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RoutingIdentificationModel.RoutingIdentificationModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RoutingIdentificationModel.RoutingIdentificationModelBuilder o = (RoutingIdentificationModel.RoutingIdentificationModelBuilder) other;
			
			merger.mergeRosetta(getRoutingIds(), o.getRoutingIds(), this::setRoutingIds);
			merger.mergeRosetta(getRoutingExplicitDetails(), o.getRoutingExplicitDetails(), this::setRoutingExplicitDetails);
			merger.mergeRosetta(getRoutingIdsAndExplicitDetails(), o.getRoutingIdsAndExplicitDetails(), this::setRoutingIdsAndExplicitDetails);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RoutingIdentificationModel _that = getType().cast(o);
		
			if (!Objects.equals(routingIds, _that.getRoutingIds())) return false;
			if (!Objects.equals(routingExplicitDetails, _that.getRoutingExplicitDetails())) return false;
			if (!Objects.equals(routingIdsAndExplicitDetails, _that.getRoutingIdsAndExplicitDetails())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingIds != null ? routingIds.hashCode() : 0);
			_result = 31 * _result + (routingExplicitDetails != null ? routingExplicitDetails.hashCode() : 0);
			_result = 31 * _result + (routingIdsAndExplicitDetails != null ? routingIdsAndExplicitDetails.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RoutingIdentificationModelBuilder {" +
				"routingIds=" + this.routingIds + ", " +
				"routingExplicitDetails=" + this.routingExplicitDetails + ", " +
				"routingIdsAndExplicitDetails=" + this.routingIdsAndExplicitDetails +
			'}';
		}
	}
}
