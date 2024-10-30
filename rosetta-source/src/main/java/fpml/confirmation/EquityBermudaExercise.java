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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.DateList;
import fpml.confirmation.DeterminationMethod;
import fpml.confirmation.EquityBermudaExercise;
import fpml.confirmation.EquityBermudaExercise.EquityBermudaExerciseBuilder;
import fpml.confirmation.EquityBermudaExercise.EquityBermudaExerciseBuilderImpl;
import fpml.confirmation.EquityBermudaExercise.EquityBermudaExerciseImpl;
import fpml.confirmation.EquityExpirationModel;
import fpml.confirmation.EquityMultipleExercise;
import fpml.confirmation.SharedAmericanExercise;
import fpml.confirmation.SharedAmericanExercise.SharedAmericanExerciseBuilder;
import fpml.confirmation.SharedAmericanExercise.SharedAmericanExerciseBuilderImpl;
import fpml.confirmation.SharedAmericanExercise.SharedAmericanExerciseImpl;
import fpml.confirmation.TimeTypeEnum;
import fpml.confirmation.meta.EquityBermudaExerciseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining exercise procedures associated with a Bermuda style exercise of an equity option. The term Bermuda is adopted in FpML for consistency with the ISDA Definitions.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="EquityBermudaExercise", builder=EquityBermudaExercise.EquityBermudaExerciseBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface EquityBermudaExercise extends SharedAmericanExercise {

	EquityBermudaExerciseMeta metaData = new EquityBermudaExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * List of Exercise Dates for a Bermuda option.
	 */
	DateList getBermudaExerciseDates();
	/**
	 * The latest time of day at which the equity option can be exercised, for example the official closing time of the exchange.
	 */
	TimeTypeEnum getLatestExerciseTimeType();
	EquityExpirationModel getEquityExpirationModel();
	/**
	 * The presence of this element indicates that the option may be exercised on different days. It is not applicable to European options.
	 */
	EquityMultipleExercise getEquityMultipleExercise();

	/*********************** Build Methods  ***********************/
	EquityBermudaExercise build();
	
	EquityBermudaExercise.EquityBermudaExerciseBuilder toBuilder();
	
	static EquityBermudaExercise.EquityBermudaExerciseBuilder builder() {
		return new EquityBermudaExercise.EquityBermudaExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityBermudaExercise> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EquityBermudaExercise> getType() {
		return EquityBermudaExercise.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("commencementDate"), processor, AdjustableOrRelativeDate.class, getCommencementDate());
		processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.class, getExpirationDate());
		processRosetta(path.newSubPath("latestExerciseTime"), processor, BusinessCenterTime.class, getLatestExerciseTime());
		processRosetta(path.newSubPath("latestExerciseTimeDetermination"), processor, DeterminationMethod.class, getLatestExerciseTimeDetermination());
		processRosetta(path.newSubPath("bermudaExerciseDates"), processor, DateList.class, getBermudaExerciseDates());
		processor.processBasic(path.newSubPath("latestExerciseTimeType"), TimeTypeEnum.class, getLatestExerciseTimeType(), this);
		processRosetta(path.newSubPath("equityExpirationModel"), processor, EquityExpirationModel.class, getEquityExpirationModel());
		processRosetta(path.newSubPath("equityMultipleExercise"), processor, EquityMultipleExercise.class, getEquityMultipleExercise());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityBermudaExerciseBuilder extends EquityBermudaExercise, SharedAmericanExercise.SharedAmericanExerciseBuilder {
		DateList.DateListBuilder getOrCreateBermudaExerciseDates();
		DateList.DateListBuilder getBermudaExerciseDates();
		EquityExpirationModel.EquityExpirationModelBuilder getOrCreateEquityExpirationModel();
		EquityExpirationModel.EquityExpirationModelBuilder getEquityExpirationModel();
		EquityMultipleExercise.EquityMultipleExerciseBuilder getOrCreateEquityMultipleExercise();
		EquityMultipleExercise.EquityMultipleExerciseBuilder getEquityMultipleExercise();
		EquityBermudaExercise.EquityBermudaExerciseBuilder setId(String id);
		EquityBermudaExercise.EquityBermudaExerciseBuilder setCommencementDate(AdjustableOrRelativeDate commencementDate);
		EquityBermudaExercise.EquityBermudaExerciseBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate);
		EquityBermudaExercise.EquityBermudaExerciseBuilder setLatestExerciseTime(BusinessCenterTime latestExerciseTime);
		EquityBermudaExercise.EquityBermudaExerciseBuilder setLatestExerciseTimeDetermination(DeterminationMethod latestExerciseTimeDetermination);
		EquityBermudaExercise.EquityBermudaExerciseBuilder setBermudaExerciseDates(DateList bermudaExerciseDates);
		EquityBermudaExercise.EquityBermudaExerciseBuilder setLatestExerciseTimeType(TimeTypeEnum latestExerciseTimeType);
		EquityBermudaExercise.EquityBermudaExerciseBuilder setEquityExpirationModel(EquityExpirationModel equityExpirationModel);
		EquityBermudaExercise.EquityBermudaExerciseBuilder setEquityMultipleExercise(EquityMultipleExercise equityMultipleExercise);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("commencementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getCommencementDate());
			processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getExpirationDate());
			processRosetta(path.newSubPath("latestExerciseTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getLatestExerciseTime());
			processRosetta(path.newSubPath("latestExerciseTimeDetermination"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getLatestExerciseTimeDetermination());
			processRosetta(path.newSubPath("bermudaExerciseDates"), processor, DateList.DateListBuilder.class, getBermudaExerciseDates());
			processor.processBasic(path.newSubPath("latestExerciseTimeType"), TimeTypeEnum.class, getLatestExerciseTimeType(), this);
			processRosetta(path.newSubPath("equityExpirationModel"), processor, EquityExpirationModel.EquityExpirationModelBuilder.class, getEquityExpirationModel());
			processRosetta(path.newSubPath("equityMultipleExercise"), processor, EquityMultipleExercise.EquityMultipleExerciseBuilder.class, getEquityMultipleExercise());
		}
		

		EquityBermudaExercise.EquityBermudaExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of EquityBermudaExercise  ***********************/
	class EquityBermudaExerciseImpl extends SharedAmericanExercise.SharedAmericanExerciseImpl implements EquityBermudaExercise {
		private final DateList bermudaExerciseDates;
		private final TimeTypeEnum latestExerciseTimeType;
		private final EquityExpirationModel equityExpirationModel;
		private final EquityMultipleExercise equityMultipleExercise;
		
		protected EquityBermudaExerciseImpl(EquityBermudaExercise.EquityBermudaExerciseBuilder builder) {
			super(builder);
			this.bermudaExerciseDates = ofNullable(builder.getBermudaExerciseDates()).map(f->f.build()).orElse(null);
			this.latestExerciseTimeType = builder.getLatestExerciseTimeType();
			this.equityExpirationModel = ofNullable(builder.getEquityExpirationModel()).map(f->f.build()).orElse(null);
			this.equityMultipleExercise = ofNullable(builder.getEquityMultipleExercise()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("bermudaExerciseDates")
		public DateList getBermudaExerciseDates() {
			return bermudaExerciseDates;
		}
		
		@Override
		@RosettaAttribute("latestExerciseTimeType")
		public TimeTypeEnum getLatestExerciseTimeType() {
			return latestExerciseTimeType;
		}
		
		@Override
		@RosettaAttribute("equityExpirationModel")
		public EquityExpirationModel getEquityExpirationModel() {
			return equityExpirationModel;
		}
		
		@Override
		@RosettaAttribute("equityMultipleExercise")
		public EquityMultipleExercise getEquityMultipleExercise() {
			return equityMultipleExercise;
		}
		
		@Override
		public EquityBermudaExercise build() {
			return this;
		}
		
		@Override
		public EquityBermudaExercise.EquityBermudaExerciseBuilder toBuilder() {
			EquityBermudaExercise.EquityBermudaExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityBermudaExercise.EquityBermudaExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBermudaExerciseDates()).ifPresent(builder::setBermudaExerciseDates);
			ofNullable(getLatestExerciseTimeType()).ifPresent(builder::setLatestExerciseTimeType);
			ofNullable(getEquityExpirationModel()).ifPresent(builder::setEquityExpirationModel);
			ofNullable(getEquityMultipleExercise()).ifPresent(builder::setEquityMultipleExercise);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityBermudaExercise _that = getType().cast(o);
		
			if (!Objects.equals(bermudaExerciseDates, _that.getBermudaExerciseDates())) return false;
			if (!Objects.equals(latestExerciseTimeType, _that.getLatestExerciseTimeType())) return false;
			if (!Objects.equals(equityExpirationModel, _that.getEquityExpirationModel())) return false;
			if (!Objects.equals(equityMultipleExercise, _that.getEquityMultipleExercise())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (bermudaExerciseDates != null ? bermudaExerciseDates.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTimeType != null ? latestExerciseTimeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (equityExpirationModel != null ? equityExpirationModel.hashCode() : 0);
			_result = 31 * _result + (equityMultipleExercise != null ? equityMultipleExercise.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityBermudaExercise {" +
				"bermudaExerciseDates=" + this.bermudaExerciseDates + ", " +
				"latestExerciseTimeType=" + this.latestExerciseTimeType + ", " +
				"equityExpirationModel=" + this.equityExpirationModel + ", " +
				"equityMultipleExercise=" + this.equityMultipleExercise +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EquityBermudaExercise  ***********************/
	class EquityBermudaExerciseBuilderImpl extends SharedAmericanExercise.SharedAmericanExerciseBuilderImpl  implements EquityBermudaExercise.EquityBermudaExerciseBuilder {
	
		protected DateList.DateListBuilder bermudaExerciseDates;
		protected TimeTypeEnum latestExerciseTimeType;
		protected EquityExpirationModel.EquityExpirationModelBuilder equityExpirationModel;
		protected EquityMultipleExercise.EquityMultipleExerciseBuilder equityMultipleExercise;
	
		public EquityBermudaExerciseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("bermudaExerciseDates")
		public DateList.DateListBuilder getBermudaExerciseDates() {
			return bermudaExerciseDates;
		}
		
		@Override
		public DateList.DateListBuilder getOrCreateBermudaExerciseDates() {
			DateList.DateListBuilder result;
			if (bermudaExerciseDates!=null) {
				result = bermudaExerciseDates;
			}
			else {
				result = bermudaExerciseDates = DateList.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("latestExerciseTimeType")
		public TimeTypeEnum getLatestExerciseTimeType() {
			return latestExerciseTimeType;
		}
		
		@Override
		@RosettaAttribute("equityExpirationModel")
		public EquityExpirationModel.EquityExpirationModelBuilder getEquityExpirationModel() {
			return equityExpirationModel;
		}
		
		@Override
		public EquityExpirationModel.EquityExpirationModelBuilder getOrCreateEquityExpirationModel() {
			EquityExpirationModel.EquityExpirationModelBuilder result;
			if (equityExpirationModel!=null) {
				result = equityExpirationModel;
			}
			else {
				result = equityExpirationModel = EquityExpirationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("equityMultipleExercise")
		public EquityMultipleExercise.EquityMultipleExerciseBuilder getEquityMultipleExercise() {
			return equityMultipleExercise;
		}
		
		@Override
		public EquityMultipleExercise.EquityMultipleExerciseBuilder getOrCreateEquityMultipleExercise() {
			EquityMultipleExercise.EquityMultipleExerciseBuilder result;
			if (equityMultipleExercise!=null) {
				result = equityMultipleExercise;
			}
			else {
				result = equityMultipleExercise = EquityMultipleExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public EquityBermudaExercise.EquityBermudaExerciseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("commencementDate")
		public EquityBermudaExercise.EquityBermudaExerciseBuilder setCommencementDate(AdjustableOrRelativeDate commencementDate) {
			this.commencementDate = commencementDate==null?null:commencementDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("expirationDate")
		public EquityBermudaExercise.EquityBermudaExerciseBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate) {
			this.expirationDate = expirationDate==null?null:expirationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("latestExerciseTime")
		public EquityBermudaExercise.EquityBermudaExerciseBuilder setLatestExerciseTime(BusinessCenterTime latestExerciseTime) {
			this.latestExerciseTime = latestExerciseTime==null?null:latestExerciseTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("latestExerciseTimeDetermination")
		public EquityBermudaExercise.EquityBermudaExerciseBuilder setLatestExerciseTimeDetermination(DeterminationMethod latestExerciseTimeDetermination) {
			this.latestExerciseTimeDetermination = latestExerciseTimeDetermination==null?null:latestExerciseTimeDetermination.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("bermudaExerciseDates")
		public EquityBermudaExercise.EquityBermudaExerciseBuilder setBermudaExerciseDates(DateList bermudaExerciseDates) {
			this.bermudaExerciseDates = bermudaExerciseDates==null?null:bermudaExerciseDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("latestExerciseTimeType")
		public EquityBermudaExercise.EquityBermudaExerciseBuilder setLatestExerciseTimeType(TimeTypeEnum latestExerciseTimeType) {
			this.latestExerciseTimeType = latestExerciseTimeType==null?null:latestExerciseTimeType;
			return this;
		}
		@Override
		@RosettaAttribute("equityExpirationModel")
		public EquityBermudaExercise.EquityBermudaExerciseBuilder setEquityExpirationModel(EquityExpirationModel equityExpirationModel) {
			this.equityExpirationModel = equityExpirationModel==null?null:equityExpirationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("equityMultipleExercise")
		public EquityBermudaExercise.EquityBermudaExerciseBuilder setEquityMultipleExercise(EquityMultipleExercise equityMultipleExercise) {
			this.equityMultipleExercise = equityMultipleExercise==null?null:equityMultipleExercise.toBuilder();
			return this;
		}
		
		@Override
		public EquityBermudaExercise build() {
			return new EquityBermudaExercise.EquityBermudaExerciseImpl(this);
		}
		
		@Override
		public EquityBermudaExercise.EquityBermudaExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityBermudaExercise.EquityBermudaExerciseBuilder prune() {
			super.prune();
			if (bermudaExerciseDates!=null && !bermudaExerciseDates.prune().hasData()) bermudaExerciseDates = null;
			if (equityExpirationModel!=null && !equityExpirationModel.prune().hasData()) equityExpirationModel = null;
			if (equityMultipleExercise!=null && !equityMultipleExercise.prune().hasData()) equityMultipleExercise = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBermudaExerciseDates()!=null && getBermudaExerciseDates().hasData()) return true;
			if (getLatestExerciseTimeType()!=null) return true;
			if (getEquityExpirationModel()!=null && getEquityExpirationModel().hasData()) return true;
			if (getEquityMultipleExercise()!=null && getEquityMultipleExercise().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityBermudaExercise.EquityBermudaExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			EquityBermudaExercise.EquityBermudaExerciseBuilder o = (EquityBermudaExercise.EquityBermudaExerciseBuilder) other;
			
			merger.mergeRosetta(getBermudaExerciseDates(), o.getBermudaExerciseDates(), this::setBermudaExerciseDates);
			merger.mergeRosetta(getEquityExpirationModel(), o.getEquityExpirationModel(), this::setEquityExpirationModel);
			merger.mergeRosetta(getEquityMultipleExercise(), o.getEquityMultipleExercise(), this::setEquityMultipleExercise);
			
			merger.mergeBasic(getLatestExerciseTimeType(), o.getLatestExerciseTimeType(), this::setLatestExerciseTimeType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityBermudaExercise _that = getType().cast(o);
		
			if (!Objects.equals(bermudaExerciseDates, _that.getBermudaExerciseDates())) return false;
			if (!Objects.equals(latestExerciseTimeType, _that.getLatestExerciseTimeType())) return false;
			if (!Objects.equals(equityExpirationModel, _that.getEquityExpirationModel())) return false;
			if (!Objects.equals(equityMultipleExercise, _that.getEquityMultipleExercise())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (bermudaExerciseDates != null ? bermudaExerciseDates.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTimeType != null ? latestExerciseTimeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (equityExpirationModel != null ? equityExpirationModel.hashCode() : 0);
			_result = 31 * _result + (equityMultipleExercise != null ? equityMultipleExercise.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityBermudaExerciseBuilder {" +
				"bermudaExerciseDates=" + this.bermudaExerciseDates + ", " +
				"latestExerciseTimeType=" + this.latestExerciseTimeType + ", " +
				"equityExpirationModel=" + this.equityExpirationModel + ", " +
				"equityMultipleExercise=" + this.equityMultipleExercise +
			'}' + " " + super.toString();
		}
	}
}
