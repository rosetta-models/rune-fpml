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
import fpml.confirmation.DayTypeEnum;
import fpml.confirmation.ParametricScheduleModelSequence2;
import fpml.confirmation.ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Builder;
import fpml.confirmation.ParametricScheduleModelSequence2.ParametricScheduleModelSequence2BuilderImpl;
import fpml.confirmation.ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Impl;
import fpml.confirmation.meta.ParametricScheduleModelSequence2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ParametricScheduleModelSequence2", builder=ParametricScheduleModelSequence2.ParametricScheduleModelSequence2BuilderImpl.class, version="${project.version}")
public interface ParametricScheduleModelSequence2 extends RosettaModelObject {

	ParametricScheduleModelSequence2Meta metaData = new ParametricScheduleModelSequence2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A day type classification, e.g. Business, Calendar, etc.
	 */
	DayTypeEnum getDayType();
	BusinessCentersOrReferenceModel getBusinessCentersOrReferenceModel();

	/*********************** Build Methods  ***********************/
	ParametricScheduleModelSequence2 build();
	
	ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Builder toBuilder();
	
	static ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Builder builder() {
		return new ParametricScheduleModelSequence2.ParametricScheduleModelSequence2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ParametricScheduleModelSequence2> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ParametricScheduleModelSequence2> getType() {
		return ParametricScheduleModelSequence2.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
		processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.class, getBusinessCentersOrReferenceModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ParametricScheduleModelSequence2Builder extends ParametricScheduleModelSequence2, RosettaModelObjectBuilder {
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getOrCreateBusinessCentersOrReferenceModel();
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getBusinessCentersOrReferenceModel();
		ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Builder setDayType(DayTypeEnum dayType);
		ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Builder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
			processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder.class, getBusinessCentersOrReferenceModel());
		}
		

		ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Builder prune();
	}

	/*********************** Immutable Implementation of ParametricScheduleModelSequence2  ***********************/
	class ParametricScheduleModelSequence2Impl implements ParametricScheduleModelSequence2 {
		private final DayTypeEnum dayType;
		private final BusinessCentersOrReferenceModel businessCentersOrReferenceModel;
		
		protected ParametricScheduleModelSequence2Impl(ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Builder builder) {
			this.dayType = builder.getDayType();
			this.businessCentersOrReferenceModel = ofNullable(builder.getBusinessCentersOrReferenceModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dayType")
		public DayTypeEnum getDayType() {
			return dayType;
		}
		
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public BusinessCentersOrReferenceModel getBusinessCentersOrReferenceModel() {
			return businessCentersOrReferenceModel;
		}
		
		@Override
		public ParametricScheduleModelSequence2 build() {
			return this;
		}
		
		@Override
		public ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Builder toBuilder() {
			ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Builder builder) {
			ofNullable(getDayType()).ifPresent(builder::setDayType);
			ofNullable(getBusinessCentersOrReferenceModel()).ifPresent(builder::setBusinessCentersOrReferenceModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ParametricScheduleModelSequence2 _that = getType().cast(o);
		
			if (!Objects.equals(dayType, _that.getDayType())) return false;
			if (!Objects.equals(businessCentersOrReferenceModel, _that.getBusinessCentersOrReferenceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dayType != null ? dayType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCentersOrReferenceModel != null ? businessCentersOrReferenceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ParametricScheduleModelSequence2 {" +
				"dayType=" + this.dayType + ", " +
				"businessCentersOrReferenceModel=" + this.businessCentersOrReferenceModel +
			'}';
		}
	}

	/*********************** Builder Implementation of ParametricScheduleModelSequence2  ***********************/
	class ParametricScheduleModelSequence2BuilderImpl implements ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Builder {
	
		protected DayTypeEnum dayType;
		protected BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder businessCentersOrReferenceModel;
	
		public ParametricScheduleModelSequence2BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dayType")
		public DayTypeEnum getDayType() {
			return dayType;
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
		@RosettaAttribute("dayType")
		public ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Builder setDayType(DayTypeEnum dayType) {
			this.dayType = dayType==null?null:dayType;
			return this;
		}
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Builder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel) {
			this.businessCentersOrReferenceModel = businessCentersOrReferenceModel==null?null:businessCentersOrReferenceModel.toBuilder();
			return this;
		}
		
		@Override
		public ParametricScheduleModelSequence2 build() {
			return new ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Impl(this);
		}
		
		@Override
		public ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Builder prune() {
			if (businessCentersOrReferenceModel!=null && !businessCentersOrReferenceModel.prune().hasData()) businessCentersOrReferenceModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDayType()!=null) return true;
			if (getBusinessCentersOrReferenceModel()!=null && getBusinessCentersOrReferenceModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Builder o = (ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Builder) other;
			
			merger.mergeRosetta(getBusinessCentersOrReferenceModel(), o.getBusinessCentersOrReferenceModel(), this::setBusinessCentersOrReferenceModel);
			
			merger.mergeBasic(getDayType(), o.getDayType(), this::setDayType);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ParametricScheduleModelSequence2 _that = getType().cast(o);
		
			if (!Objects.equals(dayType, _that.getDayType())) return false;
			if (!Objects.equals(businessCentersOrReferenceModel, _that.getBusinessCentersOrReferenceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dayType != null ? dayType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCentersOrReferenceModel != null ? businessCentersOrReferenceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ParametricScheduleModelSequence2Builder {" +
				"dayType=" + this.dayType + ", " +
				"businessCentersOrReferenceModel=" + this.businessCentersOrReferenceModel +
			'}';
		}
	}
}
