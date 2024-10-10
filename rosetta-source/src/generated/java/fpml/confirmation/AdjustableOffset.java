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
import fpml.confirmation.AdjustableOffset;
import fpml.confirmation.AdjustableOffset.AdjustableOffsetBuilder;
import fpml.confirmation.AdjustableOffset.AdjustableOffsetBuilderImpl;
import fpml.confirmation.AdjustableOffset.AdjustableOffsetImpl;
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.DayTypeEnum;
import fpml.confirmation.Offset;
import fpml.confirmation.Offset.OffsetBuilder;
import fpml.confirmation.Offset.OffsetBuilderImpl;
import fpml.confirmation.Offset.OffsetImpl;
import fpml.confirmation.PeriodEnum;
import fpml.confirmation.meta.AdjustableOffsetMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An adjustable offset can be used to specify a number of days, business or calendar, for example in a notice period.
 * @version ${project.version}
 */
@RosettaDataType(value="AdjustableOffset", builder=AdjustableOffset.AdjustableOffsetBuilderImpl.class, version="${project.version}")
public interface AdjustableOffset extends Offset {

	AdjustableOffsetMeta metaData = new AdjustableOffsetMeta();

	/*********************** Getter Methods  ***********************/
	BusinessCentersOrReferenceModel getBusinessCentersOrReferenceModel();

	/*********************** Build Methods  ***********************/
	AdjustableOffset build();
	
	AdjustableOffset.AdjustableOffsetBuilder toBuilder();
	
	static AdjustableOffset.AdjustableOffsetBuilder builder() {
		return new AdjustableOffset.AdjustableOffsetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustableOffset> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AdjustableOffset> getType() {
		return AdjustableOffset.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
		processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.class, getBusinessCentersOrReferenceModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustableOffsetBuilder extends AdjustableOffset, Offset.OffsetBuilder {
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getOrCreateBusinessCentersOrReferenceModel();
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getBusinessCentersOrReferenceModel();
		AdjustableOffset.AdjustableOffsetBuilder setPeriodMultiplier(Integer periodMultiplier);
		AdjustableOffset.AdjustableOffsetBuilder setPeriod(PeriodEnum period);
		AdjustableOffset.AdjustableOffsetBuilder setId(String id);
		AdjustableOffset.AdjustableOffsetBuilder setDayType(DayTypeEnum dayType);
		AdjustableOffset.AdjustableOffsetBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
			processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder.class, getBusinessCentersOrReferenceModel());
		}
		

		AdjustableOffset.AdjustableOffsetBuilder prune();
	}

	/*********************** Immutable Implementation of AdjustableOffset  ***********************/
	class AdjustableOffsetImpl extends Offset.OffsetImpl implements AdjustableOffset {
		private final BusinessCentersOrReferenceModel businessCentersOrReferenceModel;
		
		protected AdjustableOffsetImpl(AdjustableOffset.AdjustableOffsetBuilder builder) {
			super(builder);
			this.businessCentersOrReferenceModel = ofNullable(builder.getBusinessCentersOrReferenceModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public BusinessCentersOrReferenceModel getBusinessCentersOrReferenceModel() {
			return businessCentersOrReferenceModel;
		}
		
		@Override
		public AdjustableOffset build() {
			return this;
		}
		
		@Override
		public AdjustableOffset.AdjustableOffsetBuilder toBuilder() {
			AdjustableOffset.AdjustableOffsetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustableOffset.AdjustableOffsetBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBusinessCentersOrReferenceModel()).ifPresent(builder::setBusinessCentersOrReferenceModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AdjustableOffset _that = getType().cast(o);
		
			if (!Objects.equals(businessCentersOrReferenceModel, _that.getBusinessCentersOrReferenceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessCentersOrReferenceModel != null ? businessCentersOrReferenceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableOffset {" +
				"businessCentersOrReferenceModel=" + this.businessCentersOrReferenceModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AdjustableOffset  ***********************/
	class AdjustableOffsetBuilderImpl extends Offset.OffsetBuilderImpl  implements AdjustableOffset.AdjustableOffsetBuilder {
	
		protected BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder businessCentersOrReferenceModel;
	
		public AdjustableOffsetBuilderImpl() {
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
		@RosettaAttribute("periodMultiplier")
		public AdjustableOffset.AdjustableOffsetBuilder setPeriodMultiplier(Integer periodMultiplier) {
			this.periodMultiplier = periodMultiplier==null?null:periodMultiplier;
			return this;
		}
		@Override
		@RosettaAttribute("period")
		public AdjustableOffset.AdjustableOffsetBuilder setPeriod(PeriodEnum period) {
			this.period = period==null?null:period;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public AdjustableOffset.AdjustableOffsetBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("dayType")
		public AdjustableOffset.AdjustableOffsetBuilder setDayType(DayTypeEnum dayType) {
			this.dayType = dayType==null?null:dayType;
			return this;
		}
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public AdjustableOffset.AdjustableOffsetBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel) {
			this.businessCentersOrReferenceModel = businessCentersOrReferenceModel==null?null:businessCentersOrReferenceModel.toBuilder();
			return this;
		}
		
		@Override
		public AdjustableOffset build() {
			return new AdjustableOffset.AdjustableOffsetImpl(this);
		}
		
		@Override
		public AdjustableOffset.AdjustableOffsetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableOffset.AdjustableOffsetBuilder prune() {
			super.prune();
			if (businessCentersOrReferenceModel!=null && !businessCentersOrReferenceModel.prune().hasData()) businessCentersOrReferenceModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBusinessCentersOrReferenceModel()!=null && getBusinessCentersOrReferenceModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableOffset.AdjustableOffsetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AdjustableOffset.AdjustableOffsetBuilder o = (AdjustableOffset.AdjustableOffsetBuilder) other;
			
			merger.mergeRosetta(getBusinessCentersOrReferenceModel(), o.getBusinessCentersOrReferenceModel(), this::setBusinessCentersOrReferenceModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AdjustableOffset _that = getType().cast(o);
		
			if (!Objects.equals(businessCentersOrReferenceModel, _that.getBusinessCentersOrReferenceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessCentersOrReferenceModel != null ? businessCentersOrReferenceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableOffsetBuilder {" +
				"businessCentersOrReferenceModel=" + this.businessCentersOrReferenceModel +
			'}' + " " + super.toString();
		}
	}
}
