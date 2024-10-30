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
import fpml.confirmation.DeterminationMethod;
import fpml.confirmation.EquityAmericanExercise;
import fpml.confirmation.EquityAmericanExercise.EquityAmericanExerciseBuilder;
import fpml.confirmation.EquityAmericanExercise.EquityAmericanExerciseBuilderImpl;
import fpml.confirmation.EquityAmericanExercise.EquityAmericanExerciseImpl;
import fpml.confirmation.EquityExpirationModel;
import fpml.confirmation.EquityMultipleExercise;
import fpml.confirmation.SharedAmericanExercise;
import fpml.confirmation.SharedAmericanExercise.SharedAmericanExerciseBuilder;
import fpml.confirmation.SharedAmericanExercise.SharedAmericanExerciseBuilderImpl;
import fpml.confirmation.SharedAmericanExercise.SharedAmericanExerciseImpl;
import fpml.confirmation.TimeTypeEnum;
import fpml.confirmation.meta.EquityAmericanExerciseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining exercise procedures associated with an American style exercise of an equity option. This entity inherits from the type SharedAmericanExercise.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="EquityAmericanExercise", builder=EquityAmericanExercise.EquityAmericanExerciseBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface EquityAmericanExercise extends SharedAmericanExercise {

	EquityAmericanExerciseMeta metaData = new EquityAmericanExerciseMeta();

	/*********************** Getter Methods  ***********************/
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
	EquityAmericanExercise build();
	
	EquityAmericanExercise.EquityAmericanExerciseBuilder toBuilder();
	
	static EquityAmericanExercise.EquityAmericanExerciseBuilder builder() {
		return new EquityAmericanExercise.EquityAmericanExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityAmericanExercise> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EquityAmericanExercise> getType() {
		return EquityAmericanExercise.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("commencementDate"), processor, AdjustableOrRelativeDate.class, getCommencementDate());
		processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.class, getExpirationDate());
		processRosetta(path.newSubPath("latestExerciseTime"), processor, BusinessCenterTime.class, getLatestExerciseTime());
		processRosetta(path.newSubPath("latestExerciseTimeDetermination"), processor, DeterminationMethod.class, getLatestExerciseTimeDetermination());
		processor.processBasic(path.newSubPath("latestExerciseTimeType"), TimeTypeEnum.class, getLatestExerciseTimeType(), this);
		processRosetta(path.newSubPath("equityExpirationModel"), processor, EquityExpirationModel.class, getEquityExpirationModel());
		processRosetta(path.newSubPath("equityMultipleExercise"), processor, EquityMultipleExercise.class, getEquityMultipleExercise());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityAmericanExerciseBuilder extends EquityAmericanExercise, SharedAmericanExercise.SharedAmericanExerciseBuilder {
		EquityExpirationModel.EquityExpirationModelBuilder getOrCreateEquityExpirationModel();
		EquityExpirationModel.EquityExpirationModelBuilder getEquityExpirationModel();
		EquityMultipleExercise.EquityMultipleExerciseBuilder getOrCreateEquityMultipleExercise();
		EquityMultipleExercise.EquityMultipleExerciseBuilder getEquityMultipleExercise();
		EquityAmericanExercise.EquityAmericanExerciseBuilder setId(String id);
		EquityAmericanExercise.EquityAmericanExerciseBuilder setCommencementDate(AdjustableOrRelativeDate commencementDate);
		EquityAmericanExercise.EquityAmericanExerciseBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate);
		EquityAmericanExercise.EquityAmericanExerciseBuilder setLatestExerciseTime(BusinessCenterTime latestExerciseTime);
		EquityAmericanExercise.EquityAmericanExerciseBuilder setLatestExerciseTimeDetermination(DeterminationMethod latestExerciseTimeDetermination);
		EquityAmericanExercise.EquityAmericanExerciseBuilder setLatestExerciseTimeType(TimeTypeEnum latestExerciseTimeType);
		EquityAmericanExercise.EquityAmericanExerciseBuilder setEquityExpirationModel(EquityExpirationModel equityExpirationModel);
		EquityAmericanExercise.EquityAmericanExerciseBuilder setEquityMultipleExercise(EquityMultipleExercise equityMultipleExercise);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("commencementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getCommencementDate());
			processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getExpirationDate());
			processRosetta(path.newSubPath("latestExerciseTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getLatestExerciseTime());
			processRosetta(path.newSubPath("latestExerciseTimeDetermination"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getLatestExerciseTimeDetermination());
			processor.processBasic(path.newSubPath("latestExerciseTimeType"), TimeTypeEnum.class, getLatestExerciseTimeType(), this);
			processRosetta(path.newSubPath("equityExpirationModel"), processor, EquityExpirationModel.EquityExpirationModelBuilder.class, getEquityExpirationModel());
			processRosetta(path.newSubPath("equityMultipleExercise"), processor, EquityMultipleExercise.EquityMultipleExerciseBuilder.class, getEquityMultipleExercise());
		}
		

		EquityAmericanExercise.EquityAmericanExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of EquityAmericanExercise  ***********************/
	class EquityAmericanExerciseImpl extends SharedAmericanExercise.SharedAmericanExerciseImpl implements EquityAmericanExercise {
		private final TimeTypeEnum latestExerciseTimeType;
		private final EquityExpirationModel equityExpirationModel;
		private final EquityMultipleExercise equityMultipleExercise;
		
		protected EquityAmericanExerciseImpl(EquityAmericanExercise.EquityAmericanExerciseBuilder builder) {
			super(builder);
			this.latestExerciseTimeType = builder.getLatestExerciseTimeType();
			this.equityExpirationModel = ofNullable(builder.getEquityExpirationModel()).map(f->f.build()).orElse(null);
			this.equityMultipleExercise = ofNullable(builder.getEquityMultipleExercise()).map(f->f.build()).orElse(null);
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
		public EquityAmericanExercise build() {
			return this;
		}
		
		@Override
		public EquityAmericanExercise.EquityAmericanExerciseBuilder toBuilder() {
			EquityAmericanExercise.EquityAmericanExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityAmericanExercise.EquityAmericanExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLatestExerciseTimeType()).ifPresent(builder::setLatestExerciseTimeType);
			ofNullable(getEquityExpirationModel()).ifPresent(builder::setEquityExpirationModel);
			ofNullable(getEquityMultipleExercise()).ifPresent(builder::setEquityMultipleExercise);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityAmericanExercise _that = getType().cast(o);
		
			if (!Objects.equals(latestExerciseTimeType, _that.getLatestExerciseTimeType())) return false;
			if (!Objects.equals(equityExpirationModel, _that.getEquityExpirationModel())) return false;
			if (!Objects.equals(equityMultipleExercise, _that.getEquityMultipleExercise())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (latestExerciseTimeType != null ? latestExerciseTimeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (equityExpirationModel != null ? equityExpirationModel.hashCode() : 0);
			_result = 31 * _result + (equityMultipleExercise != null ? equityMultipleExercise.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityAmericanExercise {" +
				"latestExerciseTimeType=" + this.latestExerciseTimeType + ", " +
				"equityExpirationModel=" + this.equityExpirationModel + ", " +
				"equityMultipleExercise=" + this.equityMultipleExercise +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EquityAmericanExercise  ***********************/
	class EquityAmericanExerciseBuilderImpl extends SharedAmericanExercise.SharedAmericanExerciseBuilderImpl  implements EquityAmericanExercise.EquityAmericanExerciseBuilder {
	
		protected TimeTypeEnum latestExerciseTimeType;
		protected EquityExpirationModel.EquityExpirationModelBuilder equityExpirationModel;
		protected EquityMultipleExercise.EquityMultipleExerciseBuilder equityMultipleExercise;
	
		public EquityAmericanExerciseBuilderImpl() {
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
		public EquityAmericanExercise.EquityAmericanExerciseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("commencementDate")
		public EquityAmericanExercise.EquityAmericanExerciseBuilder setCommencementDate(AdjustableOrRelativeDate commencementDate) {
			this.commencementDate = commencementDate==null?null:commencementDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("expirationDate")
		public EquityAmericanExercise.EquityAmericanExerciseBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate) {
			this.expirationDate = expirationDate==null?null:expirationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("latestExerciseTime")
		public EquityAmericanExercise.EquityAmericanExerciseBuilder setLatestExerciseTime(BusinessCenterTime latestExerciseTime) {
			this.latestExerciseTime = latestExerciseTime==null?null:latestExerciseTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("latestExerciseTimeDetermination")
		public EquityAmericanExercise.EquityAmericanExerciseBuilder setLatestExerciseTimeDetermination(DeterminationMethod latestExerciseTimeDetermination) {
			this.latestExerciseTimeDetermination = latestExerciseTimeDetermination==null?null:latestExerciseTimeDetermination.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("latestExerciseTimeType")
		public EquityAmericanExercise.EquityAmericanExerciseBuilder setLatestExerciseTimeType(TimeTypeEnum latestExerciseTimeType) {
			this.latestExerciseTimeType = latestExerciseTimeType==null?null:latestExerciseTimeType;
			return this;
		}
		@Override
		@RosettaAttribute("equityExpirationModel")
		public EquityAmericanExercise.EquityAmericanExerciseBuilder setEquityExpirationModel(EquityExpirationModel equityExpirationModel) {
			this.equityExpirationModel = equityExpirationModel==null?null:equityExpirationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("equityMultipleExercise")
		public EquityAmericanExercise.EquityAmericanExerciseBuilder setEquityMultipleExercise(EquityMultipleExercise equityMultipleExercise) {
			this.equityMultipleExercise = equityMultipleExercise==null?null:equityMultipleExercise.toBuilder();
			return this;
		}
		
		@Override
		public EquityAmericanExercise build() {
			return new EquityAmericanExercise.EquityAmericanExerciseImpl(this);
		}
		
		@Override
		public EquityAmericanExercise.EquityAmericanExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityAmericanExercise.EquityAmericanExerciseBuilder prune() {
			super.prune();
			if (equityExpirationModel!=null && !equityExpirationModel.prune().hasData()) equityExpirationModel = null;
			if (equityMultipleExercise!=null && !equityMultipleExercise.prune().hasData()) equityMultipleExercise = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLatestExerciseTimeType()!=null) return true;
			if (getEquityExpirationModel()!=null && getEquityExpirationModel().hasData()) return true;
			if (getEquityMultipleExercise()!=null && getEquityMultipleExercise().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityAmericanExercise.EquityAmericanExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			EquityAmericanExercise.EquityAmericanExerciseBuilder o = (EquityAmericanExercise.EquityAmericanExerciseBuilder) other;
			
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
		
			EquityAmericanExercise _that = getType().cast(o);
		
			if (!Objects.equals(latestExerciseTimeType, _that.getLatestExerciseTimeType())) return false;
			if (!Objects.equals(equityExpirationModel, _that.getEquityExpirationModel())) return false;
			if (!Objects.equals(equityMultipleExercise, _that.getEquityMultipleExercise())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (latestExerciseTimeType != null ? latestExerciseTimeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (equityExpirationModel != null ? equityExpirationModel.hashCode() : 0);
			_result = 31 * _result + (equityMultipleExercise != null ? equityMultipleExercise.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityAmericanExerciseBuilder {" +
				"latestExerciseTimeType=" + this.latestExerciseTimeType + ", " +
				"equityExpirationModel=" + this.equityExpirationModel + ", " +
				"equityMultipleExercise=" + this.equityMultipleExercise +
			'}' + " " + super.toString();
		}
	}
}
