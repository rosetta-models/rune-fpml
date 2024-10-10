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
import fpml.confirmation.BusinessCenters;
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder;
import fpml.confirmation.BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilderImpl;
import fpml.confirmation.BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelImpl;
import fpml.confirmation.BusinessCentersReference;
import fpml.confirmation.meta.BusinessCentersOrReferenceModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="BusinessCentersOrReferenceModel", builder=BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilderImpl.class, version="${project.version}")
public interface BusinessCentersOrReferenceModel extends RosettaModelObject {

	BusinessCentersOrReferenceModelMeta metaData = new BusinessCentersOrReferenceModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A pointer style reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
	 */
	BusinessCentersReference getBusinessCentersReference();
	BusinessCenters getBusinessCenters();

	/*********************** Build Methods  ***********************/
	BusinessCentersOrReferenceModel build();
	
	BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder toBuilder();
	
	static BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder builder() {
		return new BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BusinessCentersOrReferenceModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BusinessCentersOrReferenceModel> getType() {
		return BusinessCentersOrReferenceModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("businessCentersReference"), processor, BusinessCentersReference.class, getBusinessCentersReference());
		processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.class, getBusinessCenters());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BusinessCentersOrReferenceModelBuilder extends BusinessCentersOrReferenceModel, RosettaModelObjectBuilder {
		BusinessCentersReference.BusinessCentersReferenceBuilder getOrCreateBusinessCentersReference();
		BusinessCentersReference.BusinessCentersReferenceBuilder getBusinessCentersReference();
		BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters();
		BusinessCenters.BusinessCentersBuilder getBusinessCenters();
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder setBusinessCentersReference(BusinessCentersReference businessCentersReference);
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder setBusinessCenters(BusinessCenters businessCenters);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("businessCentersReference"), processor, BusinessCentersReference.BusinessCentersReferenceBuilder.class, getBusinessCentersReference());
			processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.BusinessCentersBuilder.class, getBusinessCenters());
		}
		

		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder prune();
	}

	/*********************** Immutable Implementation of BusinessCentersOrReferenceModel  ***********************/
	class BusinessCentersOrReferenceModelImpl implements BusinessCentersOrReferenceModel {
		private final BusinessCentersReference businessCentersReference;
		private final BusinessCenters businessCenters;
		
		protected BusinessCentersOrReferenceModelImpl(BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder builder) {
			this.businessCentersReference = ofNullable(builder.getBusinessCentersReference()).map(f->f.build()).orElse(null);
			this.businessCenters = ofNullable(builder.getBusinessCenters()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("businessCentersReference")
		public BusinessCentersReference getBusinessCentersReference() {
			return businessCentersReference;
		}
		
		@Override
		@RosettaAttribute("businessCenters")
		public BusinessCenters getBusinessCenters() {
			return businessCenters;
		}
		
		@Override
		public BusinessCentersOrReferenceModel build() {
			return this;
		}
		
		@Override
		public BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder toBuilder() {
			BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder builder) {
			ofNullable(getBusinessCentersReference()).ifPresent(builder::setBusinessCentersReference);
			ofNullable(getBusinessCenters()).ifPresent(builder::setBusinessCenters);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessCentersOrReferenceModel _that = getType().cast(o);
		
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessCentersOrReferenceModel {" +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"businessCenters=" + this.businessCenters +
			'}';
		}
	}

	/*********************** Builder Implementation of BusinessCentersOrReferenceModel  ***********************/
	class BusinessCentersOrReferenceModelBuilderImpl implements BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder {
	
		protected BusinessCentersReference.BusinessCentersReferenceBuilder businessCentersReference;
		protected BusinessCenters.BusinessCentersBuilder businessCenters;
	
		public BusinessCentersOrReferenceModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("businessCentersReference")
		public BusinessCentersReference.BusinessCentersReferenceBuilder getBusinessCentersReference() {
			return businessCentersReference;
		}
		
		@Override
		public BusinessCentersReference.BusinessCentersReferenceBuilder getOrCreateBusinessCentersReference() {
			BusinessCentersReference.BusinessCentersReferenceBuilder result;
			if (businessCentersReference!=null) {
				result = businessCentersReference;
			}
			else {
				result = businessCentersReference = BusinessCentersReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("businessCenters")
		public BusinessCenters.BusinessCentersBuilder getBusinessCenters() {
			return businessCenters;
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters() {
			BusinessCenters.BusinessCentersBuilder result;
			if (businessCenters!=null) {
				result = businessCenters;
			}
			else {
				result = businessCenters = BusinessCenters.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("businessCentersReference")
		public BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder setBusinessCentersReference(BusinessCentersReference businessCentersReference) {
			this.businessCentersReference = businessCentersReference==null?null:businessCentersReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("businessCenters")
		public BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder setBusinessCenters(BusinessCenters businessCenters) {
			this.businessCenters = businessCenters==null?null:businessCenters.toBuilder();
			return this;
		}
		
		@Override
		public BusinessCentersOrReferenceModel build() {
			return new BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelImpl(this);
		}
		
		@Override
		public BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder prune() {
			if (businessCentersReference!=null && !businessCentersReference.prune().hasData()) businessCentersReference = null;
			if (businessCenters!=null && !businessCenters.prune().hasData()) businessCenters = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBusinessCentersReference()!=null && getBusinessCentersReference().hasData()) return true;
			if (getBusinessCenters()!=null && getBusinessCenters().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder o = (BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder) other;
			
			merger.mergeRosetta(getBusinessCentersReference(), o.getBusinessCentersReference(), this::setBusinessCentersReference);
			merger.mergeRosetta(getBusinessCenters(), o.getBusinessCenters(), this::setBusinessCenters);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessCentersOrReferenceModel _that = getType().cast(o);
		
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessCentersOrReferenceModelBuilder {" +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"businessCenters=" + this.businessCenters +
			'}';
		}
	}
}
