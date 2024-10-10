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
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.BusinessDayAdjustments.BusinessDayAdjustmentsBuilder;
import fpml.confirmation.BusinessDayAdjustments.BusinessDayAdjustmentsBuilderImpl;
import fpml.confirmation.BusinessDayAdjustments.BusinessDayAdjustmentsImpl;
import fpml.confirmation.BusinessDayConventionEnum;
import fpml.confirmation.meta.BusinessDayAdjustmentsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the business day convention and financial business centers used for adjusting any relevant date if it would otherwise fall on a day that is not a business day in the specified business centers.
 * @version ${project.version}
 */
@RosettaDataType(value="BusinessDayAdjustments", builder=BusinessDayAdjustments.BusinessDayAdjustmentsBuilderImpl.class, version="${project.version}")
public interface BusinessDayAdjustments extends RosettaModelObject {

	BusinessDayAdjustmentsMeta metaData = new BusinessDayAdjustmentsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The convention for adjusting a date if it would otherwise fall on a day that is not a business day.
	 */
	BusinessDayConventionEnum getBusinessDayConvention();
	BusinessCentersOrReferenceModel getBusinessCentersOrReferenceModel();
	String getId();

	/*********************** Build Methods  ***********************/
	BusinessDayAdjustments build();
	
	BusinessDayAdjustments.BusinessDayAdjustmentsBuilder toBuilder();
	
	static BusinessDayAdjustments.BusinessDayAdjustmentsBuilder builder() {
		return new BusinessDayAdjustments.BusinessDayAdjustmentsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BusinessDayAdjustments> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BusinessDayAdjustments> getType() {
		return BusinessDayAdjustments.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
		processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.class, getBusinessCentersOrReferenceModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BusinessDayAdjustmentsBuilder extends BusinessDayAdjustments, RosettaModelObjectBuilder {
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getOrCreateBusinessCentersOrReferenceModel();
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getBusinessCentersOrReferenceModel();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention);
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel);
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
			processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder.class, getBusinessCentersOrReferenceModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder prune();
	}

	/*********************** Immutable Implementation of BusinessDayAdjustments  ***********************/
	class BusinessDayAdjustmentsImpl implements BusinessDayAdjustments {
		private final BusinessDayConventionEnum businessDayConvention;
		private final BusinessCentersOrReferenceModel businessCentersOrReferenceModel;
		private final String id;
		
		protected BusinessDayAdjustmentsImpl(BusinessDayAdjustments.BusinessDayAdjustmentsBuilder builder) {
			this.businessDayConvention = builder.getBusinessDayConvention();
			this.businessCentersOrReferenceModel = ofNullable(builder.getBusinessCentersOrReferenceModel()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("businessDayConvention")
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public BusinessCentersOrReferenceModel getBusinessCentersOrReferenceModel() {
			return businessCentersOrReferenceModel;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public BusinessDayAdjustments build() {
			return this;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder toBuilder() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessDayAdjustments.BusinessDayAdjustmentsBuilder builder) {
			ofNullable(getBusinessDayConvention()).ifPresent(builder::setBusinessDayConvention);
			ofNullable(getBusinessCentersOrReferenceModel()).ifPresent(builder::setBusinessCentersOrReferenceModel);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessDayAdjustments _that = getType().cast(o);
		
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(businessCentersOrReferenceModel, _that.getBusinessCentersOrReferenceModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCentersOrReferenceModel != null ? businessCentersOrReferenceModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessDayAdjustments {" +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"businessCentersOrReferenceModel=" + this.businessCentersOrReferenceModel + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of BusinessDayAdjustments  ***********************/
	class BusinessDayAdjustmentsBuilderImpl implements BusinessDayAdjustments.BusinessDayAdjustmentsBuilder {
	
		protected BusinessDayConventionEnum businessDayConvention;
		protected BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder businessCentersOrReferenceModel;
		protected String id;
	
		public BusinessDayAdjustmentsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("businessDayConvention")
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getBusinessCentersOrReferenceModel() {
			return businessCentersOrReferenceModel;
		}
		
		@Override
		public BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getOrCreateBusinessCentersOrReferenceModel() {
			BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder result;
			if (businessCentersOrReferenceModel!=null) {
				result = businessCentersOrReferenceModel;
			}
			else {
				result = businessCentersOrReferenceModel = BusinessCentersOrReferenceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("businessDayConvention")
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention) {
			this.businessDayConvention = businessDayConvention==null?null:businessDayConvention;
			return this;
		}
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel) {
			this.businessCentersOrReferenceModel = businessCentersOrReferenceModel==null?null:businessCentersOrReferenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public BusinessDayAdjustments build() {
			return new BusinessDayAdjustments.BusinessDayAdjustmentsImpl(this);
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder prune() {
			if (businessCentersOrReferenceModel!=null && !businessCentersOrReferenceModel.prune().hasData()) businessCentersOrReferenceModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBusinessDayConvention()!=null) return true;
			if (getBusinessCentersOrReferenceModel()!=null && getBusinessCentersOrReferenceModel().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder o = (BusinessDayAdjustments.BusinessDayAdjustmentsBuilder) other;
			
			merger.mergeRosetta(getBusinessCentersOrReferenceModel(), o.getBusinessCentersOrReferenceModel(), this::setBusinessCentersOrReferenceModel);
			
			merger.mergeBasic(getBusinessDayConvention(), o.getBusinessDayConvention(), this::setBusinessDayConvention);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessDayAdjustments _that = getType().cast(o);
		
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			if (!Objects.equals(businessCentersOrReferenceModel, _that.getBusinessCentersOrReferenceModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCentersOrReferenceModel != null ? businessCentersOrReferenceModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessDayAdjustmentsBuilder {" +
				"businessDayConvention=" + this.businessDayConvention + ", " +
				"businessCentersOrReferenceModel=" + this.businessCentersOrReferenceModel + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
