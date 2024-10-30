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
import fpml.confirmation.FxAveragingMethodEnum;
import fpml.confirmation.FxAveragingProcess;
import fpml.confirmation.FxAveragingProcess.FxAveragingProcessBuilder;
import fpml.confirmation.FxAveragingProcess.FxAveragingProcessBuilderImpl;
import fpml.confirmation.FxAveragingProcess.FxAveragingProcessImpl;
import fpml.confirmation.FxCrossRateObservable;
import fpml.confirmation.FxInformationSource;
import fpml.confirmation.FxRateObservable;
import fpml.confirmation.FxRateObservable.FxRateObservableBuilder;
import fpml.confirmation.FxRateObservable.FxRateObservableBuilderImpl;
import fpml.confirmation.FxRateObservable.FxRateObservableImpl;
import fpml.confirmation.FxWeightedFixingSchedule;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.meta.FxAveragingProcessMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Accrual calculation process.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxAveragingProcess", builder=FxAveragingProcess.FxAveragingProcessBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxAveragingProcess extends FxRateObservable {

	FxAveragingProcessMeta metaData = new FxAveragingProcessMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Describes a parametric schedule of fixing dates.
	 */
	FxWeightedFixingSchedule getFixingSchedule();
	FxAveragingMethodEnum getAveragingMethod();
	/**
	 * Specifies the rounding precision in terms of a number of decimal places. Note how a percentage rate rounding of 5 decimal places is expressed as a rounding precision of 7 in the FpML document since the percentage is expressed as a decimal, e.g. 9.876543% (or 0.09876543) being rounded to the nearest 5 decimal places is 9.87654% (or 0.0987654).
	 */
	Integer getPrecision();

	/*********************** Build Methods  ***********************/
	FxAveragingProcess build();
	
	FxAveragingProcess.FxAveragingProcessBuilder toBuilder();
	
	static FxAveragingProcess.FxAveragingProcessBuilder builder() {
		return new FxAveragingProcess.FxAveragingProcessBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAveragingProcess> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAveragingProcess> getType() {
		return FxAveragingProcess.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processRosetta(path.newSubPath("informationSource"), processor, FxInformationSource.class, getInformationSource());
		processRosetta(path.newSubPath("crossRate"), processor, FxCrossRateObservable.class, getCrossRate());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("fixingSchedule"), processor, FxWeightedFixingSchedule.class, getFixingSchedule());
		processor.processBasic(path.newSubPath("averagingMethod"), FxAveragingMethodEnum.class, getAveragingMethod(), this);
		processor.processBasic(path.newSubPath("precision"), Integer.class, getPrecision(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAveragingProcessBuilder extends FxAveragingProcess, FxRateObservable.FxRateObservableBuilder {
		FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder getOrCreateFixingSchedule();
		FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder getFixingSchedule();
		FxAveragingProcess.FxAveragingProcessBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxAveragingProcess.FxAveragingProcessBuilder setInformationSource(FxInformationSource informationSource);
		FxAveragingProcess.FxAveragingProcessBuilder addCrossRate(FxCrossRateObservable crossRate0);
		FxAveragingProcess.FxAveragingProcessBuilder addCrossRate(FxCrossRateObservable crossRate1, int _idx);
		FxAveragingProcess.FxAveragingProcessBuilder addCrossRate(List<? extends FxCrossRateObservable> crossRate2);
		FxAveragingProcess.FxAveragingProcessBuilder setCrossRate(List<? extends FxCrossRateObservable> crossRate3);
		FxAveragingProcess.FxAveragingProcessBuilder setId(String id);
		FxAveragingProcess.FxAveragingProcessBuilder setFixingSchedule(FxWeightedFixingSchedule fixingSchedule);
		FxAveragingProcess.FxAveragingProcessBuilder setAveragingMethod(FxAveragingMethodEnum averagingMethod);
		FxAveragingProcess.FxAveragingProcessBuilder setPrecision(Integer precision);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("informationSource"), processor, FxInformationSource.FxInformationSourceBuilder.class, getInformationSource());
			processRosetta(path.newSubPath("crossRate"), processor, FxCrossRateObservable.FxCrossRateObservableBuilder.class, getCrossRate());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("fixingSchedule"), processor, FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder.class, getFixingSchedule());
			processor.processBasic(path.newSubPath("averagingMethod"), FxAveragingMethodEnum.class, getAveragingMethod(), this);
			processor.processBasic(path.newSubPath("precision"), Integer.class, getPrecision(), this);
		}
		

		FxAveragingProcess.FxAveragingProcessBuilder prune();
	}

	/*********************** Immutable Implementation of FxAveragingProcess  ***********************/
	class FxAveragingProcessImpl extends FxRateObservable.FxRateObservableImpl implements FxAveragingProcess {
		private final FxWeightedFixingSchedule fixingSchedule;
		private final FxAveragingMethodEnum averagingMethod;
		private final Integer precision;
		
		protected FxAveragingProcessImpl(FxAveragingProcess.FxAveragingProcessBuilder builder) {
			super(builder);
			this.fixingSchedule = ofNullable(builder.getFixingSchedule()).map(f->f.build()).orElse(null);
			this.averagingMethod = builder.getAveragingMethod();
			this.precision = builder.getPrecision();
		}
		
		@Override
		@RosettaAttribute("fixingSchedule")
		public FxWeightedFixingSchedule getFixingSchedule() {
			return fixingSchedule;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		public FxAveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("precision")
		public Integer getPrecision() {
			return precision;
		}
		
		@Override
		public FxAveragingProcess build() {
			return this;
		}
		
		@Override
		public FxAveragingProcess.FxAveragingProcessBuilder toBuilder() {
			FxAveragingProcess.FxAveragingProcessBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAveragingProcess.FxAveragingProcessBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFixingSchedule()).ifPresent(builder::setFixingSchedule);
			ofNullable(getAveragingMethod()).ifPresent(builder::setAveragingMethod);
			ofNullable(getPrecision()).ifPresent(builder::setPrecision);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAveragingProcess _that = getType().cast(o);
		
			if (!Objects.equals(fixingSchedule, _that.getFixingSchedule())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(precision, _that.getPrecision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixingSchedule != null ? fixingSchedule.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (precision != null ? precision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAveragingProcess {" +
				"fixingSchedule=" + this.fixingSchedule + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"precision=" + this.precision +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAveragingProcess  ***********************/
	class FxAveragingProcessBuilderImpl extends FxRateObservable.FxRateObservableBuilderImpl  implements FxAveragingProcess.FxAveragingProcessBuilder {
	
		protected FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder fixingSchedule;
		protected FxAveragingMethodEnum averagingMethod;
		protected Integer precision;
	
		public FxAveragingProcessBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fixingSchedule")
		public FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder getFixingSchedule() {
			return fixingSchedule;
		}
		
		@Override
		public FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder getOrCreateFixingSchedule() {
			FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder result;
			if (fixingSchedule!=null) {
				result = fixingSchedule;
			}
			else {
				result = fixingSchedule = FxWeightedFixingSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		public FxAveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("precision")
		public Integer getPrecision() {
			return precision;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public FxAveragingProcess.FxAveragingProcessBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("informationSource")
		public FxAveragingProcess.FxAveragingProcessBuilder setInformationSource(FxInformationSource informationSource) {
			this.informationSource = informationSource==null?null:informationSource.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("crossRate")
		public FxAveragingProcess.FxAveragingProcessBuilder addCrossRate(FxCrossRateObservable crossRate) {
			if (crossRate!=null) this.crossRate.add(crossRate.toBuilder());
			return this;
		}
		
		@Override
		public FxAveragingProcess.FxAveragingProcessBuilder addCrossRate(FxCrossRateObservable crossRate, int _idx) {
			getIndex(this.crossRate, _idx, () -> crossRate.toBuilder());
			return this;
		}
		@Override 
		public FxAveragingProcess.FxAveragingProcessBuilder addCrossRate(List<? extends FxCrossRateObservable> crossRates) {
			if (crossRates != null) {
				for (FxCrossRateObservable toAdd : crossRates) {
					this.crossRate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxAveragingProcess.FxAveragingProcessBuilder setCrossRate(List<? extends FxCrossRateObservable> crossRates) {
			if (crossRates == null)  {
				this.crossRate = new ArrayList<>();
			}
			else {
				this.crossRate = crossRates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public FxAveragingProcess.FxAveragingProcessBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("fixingSchedule")
		public FxAveragingProcess.FxAveragingProcessBuilder setFixingSchedule(FxWeightedFixingSchedule fixingSchedule) {
			this.fixingSchedule = fixingSchedule==null?null:fixingSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("averagingMethod")
		public FxAveragingProcess.FxAveragingProcessBuilder setAveragingMethod(FxAveragingMethodEnum averagingMethod) {
			this.averagingMethod = averagingMethod==null?null:averagingMethod;
			return this;
		}
		@Override
		@RosettaAttribute("precision")
		public FxAveragingProcess.FxAveragingProcessBuilder setPrecision(Integer precision) {
			this.precision = precision==null?null:precision;
			return this;
		}
		
		@Override
		public FxAveragingProcess build() {
			return new FxAveragingProcess.FxAveragingProcessImpl(this);
		}
		
		@Override
		public FxAveragingProcess.FxAveragingProcessBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAveragingProcess.FxAveragingProcessBuilder prune() {
			super.prune();
			if (fixingSchedule!=null && !fixingSchedule.prune().hasData()) fixingSchedule = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFixingSchedule()!=null && getFixingSchedule().hasData()) return true;
			if (getAveragingMethod()!=null) return true;
			if (getPrecision()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAveragingProcess.FxAveragingProcessBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxAveragingProcess.FxAveragingProcessBuilder o = (FxAveragingProcess.FxAveragingProcessBuilder) other;
			
			merger.mergeRosetta(getFixingSchedule(), o.getFixingSchedule(), this::setFixingSchedule);
			
			merger.mergeBasic(getAveragingMethod(), o.getAveragingMethod(), this::setAveragingMethod);
			merger.mergeBasic(getPrecision(), o.getPrecision(), this::setPrecision);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAveragingProcess _that = getType().cast(o);
		
			if (!Objects.equals(fixingSchedule, _that.getFixingSchedule())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(precision, _that.getPrecision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixingSchedule != null ? fixingSchedule.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (precision != null ? precision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAveragingProcessBuilder {" +
				"fixingSchedule=" + this.fixingSchedule + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"precision=" + this.precision +
			'}' + " " + super.toString();
		}
	}
}
