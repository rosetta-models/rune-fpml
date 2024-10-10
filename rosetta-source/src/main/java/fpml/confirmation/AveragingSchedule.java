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
import fpml.confirmation.AveragingSchedule;
import fpml.confirmation.AveragingSchedule.AveragingScheduleBuilder;
import fpml.confirmation.AveragingSchedule.AveragingScheduleBuilderImpl;
import fpml.confirmation.AveragingSchedule.AveragingScheduleImpl;
import fpml.confirmation.CalculationPeriodFrequency;
import fpml.confirmation.PeriodModel;
import fpml.confirmation.meta.AveragingScheduleMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Method of generating a series of dates.
 * @version ${project.version}
 */
@RosettaDataType(value="AveragingSchedule", builder=AveragingSchedule.AveragingScheduleBuilderImpl.class, version="${project.version}")
public interface AveragingSchedule extends RosettaModelObject {

	AveragingScheduleMeta metaData = new AveragingScheduleMeta();

	/*********************** Getter Methods  ***********************/
	PeriodModel getPeriodModel();
	/**
	 * The frequency at which averaging period occurs with the regular part of the valuation schedule and their roll date convention.
	 */
	CalculationPeriodFrequency getAveragingPeriodFrequency();

	/*********************** Build Methods  ***********************/
	AveragingSchedule build();
	
	AveragingSchedule.AveragingScheduleBuilder toBuilder();
	
	static AveragingSchedule.AveragingScheduleBuilder builder() {
		return new AveragingSchedule.AveragingScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AveragingSchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AveragingSchedule> getType() {
		return AveragingSchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("periodModel"), processor, PeriodModel.class, getPeriodModel());
		processRosetta(path.newSubPath("averagingPeriodFrequency"), processor, CalculationPeriodFrequency.class, getAveragingPeriodFrequency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AveragingScheduleBuilder extends AveragingSchedule, RosettaModelObjectBuilder {
		PeriodModel.PeriodModelBuilder getOrCreatePeriodModel();
		PeriodModel.PeriodModelBuilder getPeriodModel();
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getOrCreateAveragingPeriodFrequency();
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getAveragingPeriodFrequency();
		AveragingSchedule.AveragingScheduleBuilder setPeriodModel(PeriodModel periodModel);
		AveragingSchedule.AveragingScheduleBuilder setAveragingPeriodFrequency(CalculationPeriodFrequency averagingPeriodFrequency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("periodModel"), processor, PeriodModel.PeriodModelBuilder.class, getPeriodModel());
			processRosetta(path.newSubPath("averagingPeriodFrequency"), processor, CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder.class, getAveragingPeriodFrequency());
		}
		

		AveragingSchedule.AveragingScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of AveragingSchedule  ***********************/
	class AveragingScheduleImpl implements AveragingSchedule {
		private final PeriodModel periodModel;
		private final CalculationPeriodFrequency averagingPeriodFrequency;
		
		protected AveragingScheduleImpl(AveragingSchedule.AveragingScheduleBuilder builder) {
			this.periodModel = ofNullable(builder.getPeriodModel()).map(f->f.build()).orElse(null);
			this.averagingPeriodFrequency = ofNullable(builder.getAveragingPeriodFrequency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("periodModel")
		public PeriodModel getPeriodModel() {
			return periodModel;
		}
		
		@Override
		@RosettaAttribute("averagingPeriodFrequency")
		public CalculationPeriodFrequency getAveragingPeriodFrequency() {
			return averagingPeriodFrequency;
		}
		
		@Override
		public AveragingSchedule build() {
			return this;
		}
		
		@Override
		public AveragingSchedule.AveragingScheduleBuilder toBuilder() {
			AveragingSchedule.AveragingScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AveragingSchedule.AveragingScheduleBuilder builder) {
			ofNullable(getPeriodModel()).ifPresent(builder::setPeriodModel);
			ofNullable(getAveragingPeriodFrequency()).ifPresent(builder::setAveragingPeriodFrequency);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AveragingSchedule _that = getType().cast(o);
		
			if (!Objects.equals(periodModel, _that.getPeriodModel())) return false;
			if (!Objects.equals(averagingPeriodFrequency, _that.getAveragingPeriodFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (periodModel != null ? periodModel.hashCode() : 0);
			_result = 31 * _result + (averagingPeriodFrequency != null ? averagingPeriodFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AveragingSchedule {" +
				"periodModel=" + this.periodModel + ", " +
				"averagingPeriodFrequency=" + this.averagingPeriodFrequency +
			'}';
		}
	}

	/*********************** Builder Implementation of AveragingSchedule  ***********************/
	class AveragingScheduleBuilderImpl implements AveragingSchedule.AveragingScheduleBuilder {
	
		protected PeriodModel.PeriodModelBuilder periodModel;
		protected CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder averagingPeriodFrequency;
	
		public AveragingScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("periodModel")
		public PeriodModel.PeriodModelBuilder getPeriodModel() {
			return periodModel;
		}
		
		@Override
		public PeriodModel.PeriodModelBuilder getOrCreatePeriodModel() {
			PeriodModel.PeriodModelBuilder result;
			if (periodModel!=null) {
				result = periodModel;
			}
			else {
				result = periodModel = PeriodModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averagingPeriodFrequency")
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getAveragingPeriodFrequency() {
			return averagingPeriodFrequency;
		}
		
		@Override
		public CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder getOrCreateAveragingPeriodFrequency() {
			CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder result;
			if (averagingPeriodFrequency!=null) {
				result = averagingPeriodFrequency;
			}
			else {
				result = averagingPeriodFrequency = CalculationPeriodFrequency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("periodModel")
		public AveragingSchedule.AveragingScheduleBuilder setPeriodModel(PeriodModel periodModel) {
			this.periodModel = periodModel==null?null:periodModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("averagingPeriodFrequency")
		public AveragingSchedule.AveragingScheduleBuilder setAveragingPeriodFrequency(CalculationPeriodFrequency averagingPeriodFrequency) {
			this.averagingPeriodFrequency = averagingPeriodFrequency==null?null:averagingPeriodFrequency.toBuilder();
			return this;
		}
		
		@Override
		public AveragingSchedule build() {
			return new AveragingSchedule.AveragingScheduleImpl(this);
		}
		
		@Override
		public AveragingSchedule.AveragingScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AveragingSchedule.AveragingScheduleBuilder prune() {
			if (periodModel!=null && !periodModel.prune().hasData()) periodModel = null;
			if (averagingPeriodFrequency!=null && !averagingPeriodFrequency.prune().hasData()) averagingPeriodFrequency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPeriodModel()!=null && getPeriodModel().hasData()) return true;
			if (getAveragingPeriodFrequency()!=null && getAveragingPeriodFrequency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AveragingSchedule.AveragingScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AveragingSchedule.AveragingScheduleBuilder o = (AveragingSchedule.AveragingScheduleBuilder) other;
			
			merger.mergeRosetta(getPeriodModel(), o.getPeriodModel(), this::setPeriodModel);
			merger.mergeRosetta(getAveragingPeriodFrequency(), o.getAveragingPeriodFrequency(), this::setAveragingPeriodFrequency);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AveragingSchedule _that = getType().cast(o);
		
			if (!Objects.equals(periodModel, _that.getPeriodModel())) return false;
			if (!Objects.equals(averagingPeriodFrequency, _that.getAveragingPeriodFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (periodModel != null ? periodModel.hashCode() : 0);
			_result = 31 * _result + (averagingPeriodFrequency != null ? averagingPeriodFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AveragingScheduleBuilder {" +
				"periodModel=" + this.periodModel + ", " +
				"averagingPeriodFrequency=" + this.averagingPeriodFrequency +
			'}';
		}
	}
}
