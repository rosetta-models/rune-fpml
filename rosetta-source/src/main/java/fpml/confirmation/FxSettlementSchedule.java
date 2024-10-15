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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.FxSchedule;
import fpml.confirmation.FxSchedule.FxScheduleBuilder;
import fpml.confirmation.FxSchedule.FxScheduleBuilderImpl;
import fpml.confirmation.FxSchedule.FxScheduleImpl;
import fpml.confirmation.FxScheduleSequence0;
import fpml.confirmation.FxScheduleSequence1;
import fpml.confirmation.FxSettlementSchedule;
import fpml.confirmation.FxSettlementSchedule.FxSettlementScheduleBuilder;
import fpml.confirmation.FxSettlementSchedule.FxSettlementScheduleBuilderImpl;
import fpml.confirmation.FxSettlementSchedule.FxSettlementScheduleImpl;
import fpml.confirmation.meta.FxSettlementScheduleMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxSettlementSchedule", builder=FxSettlementSchedule.FxSettlementScheduleBuilderImpl.class, version="${project.version}")
public interface FxSettlementSchedule extends FxSchedule {

	FxSettlementScheduleMeta metaData = new FxSettlementScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The final settlement date facilitates informing the final date without having to process all settlement dates in the schedule.
	 */
	Date getFinalSettlementDate();

	/*********************** Build Methods  ***********************/
	FxSettlementSchedule build();
	
	FxSettlementSchedule.FxSettlementScheduleBuilder toBuilder();
	
	static FxSettlementSchedule.FxSettlementScheduleBuilder builder() {
		return new FxSettlementSchedule.FxSettlementScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxSettlementSchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxSettlementSchedule> getType() {
		return FxSettlementSchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fxScheduleSequence0"), processor, FxScheduleSequence0.class, getFxScheduleSequence0());
		processRosetta(path.newSubPath("fxScheduleSequence1"), processor, FxScheduleSequence1.class, getFxScheduleSequence1());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("finalSettlementDate"), Date.class, getFinalSettlementDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxSettlementScheduleBuilder extends FxSettlementSchedule, FxSchedule.FxScheduleBuilder {
		FxSettlementSchedule.FxSettlementScheduleBuilder setFxScheduleSequence0(FxScheduleSequence0 fxScheduleSequence0);
		FxSettlementSchedule.FxSettlementScheduleBuilder setFxScheduleSequence1(FxScheduleSequence1 fxScheduleSequence1);
		FxSettlementSchedule.FxSettlementScheduleBuilder setId(String id);
		FxSettlementSchedule.FxSettlementScheduleBuilder setFinalSettlementDate(Date finalSettlementDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fxScheduleSequence0"), processor, FxScheduleSequence0.FxScheduleSequence0Builder.class, getFxScheduleSequence0());
			processRosetta(path.newSubPath("fxScheduleSequence1"), processor, FxScheduleSequence1.FxScheduleSequence1Builder.class, getFxScheduleSequence1());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("finalSettlementDate"), Date.class, getFinalSettlementDate(), this);
		}
		

		FxSettlementSchedule.FxSettlementScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of FxSettlementSchedule  ***********************/
	class FxSettlementScheduleImpl extends FxSchedule.FxScheduleImpl implements FxSettlementSchedule {
		private final Date finalSettlementDate;
		
		protected FxSettlementScheduleImpl(FxSettlementSchedule.FxSettlementScheduleBuilder builder) {
			super(builder);
			this.finalSettlementDate = builder.getFinalSettlementDate();
		}
		
		@Override
		@RosettaAttribute("finalSettlementDate")
		public Date getFinalSettlementDate() {
			return finalSettlementDate;
		}
		
		@Override
		public FxSettlementSchedule build() {
			return this;
		}
		
		@Override
		public FxSettlementSchedule.FxSettlementScheduleBuilder toBuilder() {
			FxSettlementSchedule.FxSettlementScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxSettlementSchedule.FxSettlementScheduleBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFinalSettlementDate()).ifPresent(builder::setFinalSettlementDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxSettlementSchedule _that = getType().cast(o);
		
			if (!Objects.equals(finalSettlementDate, _that.getFinalSettlementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (finalSettlementDate != null ? finalSettlementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSettlementSchedule {" +
				"finalSettlementDate=" + this.finalSettlementDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxSettlementSchedule  ***********************/
	class FxSettlementScheduleBuilderImpl extends FxSchedule.FxScheduleBuilderImpl  implements FxSettlementSchedule.FxSettlementScheduleBuilder {
	
		protected Date finalSettlementDate;
	
		public FxSettlementScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("finalSettlementDate")
		public Date getFinalSettlementDate() {
			return finalSettlementDate;
		}
		
		@Override
		@RosettaAttribute("fxScheduleSequence0")
		public FxSettlementSchedule.FxSettlementScheduleBuilder setFxScheduleSequence0(FxScheduleSequence0 fxScheduleSequence0) {
			this.fxScheduleSequence0 = fxScheduleSequence0==null?null:fxScheduleSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxScheduleSequence1")
		public FxSettlementSchedule.FxSettlementScheduleBuilder setFxScheduleSequence1(FxScheduleSequence1 fxScheduleSequence1) {
			this.fxScheduleSequence1 = fxScheduleSequence1==null?null:fxScheduleSequence1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxSettlementSchedule.FxSettlementScheduleBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("finalSettlementDate")
		public FxSettlementSchedule.FxSettlementScheduleBuilder setFinalSettlementDate(Date finalSettlementDate) {
			this.finalSettlementDate = finalSettlementDate==null?null:finalSettlementDate;
			return this;
		}
		
		@Override
		public FxSettlementSchedule build() {
			return new FxSettlementSchedule.FxSettlementScheduleImpl(this);
		}
		
		@Override
		public FxSettlementSchedule.FxSettlementScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSettlementSchedule.FxSettlementScheduleBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFinalSettlementDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSettlementSchedule.FxSettlementScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxSettlementSchedule.FxSettlementScheduleBuilder o = (FxSettlementSchedule.FxSettlementScheduleBuilder) other;
			
			
			merger.mergeBasic(getFinalSettlementDate(), o.getFinalSettlementDate(), this::setFinalSettlementDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxSettlementSchedule _that = getType().cast(o);
		
			if (!Objects.equals(finalSettlementDate, _that.getFinalSettlementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (finalSettlementDate != null ? finalSettlementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSettlementScheduleBuilder {" +
				"finalSettlementDate=" + this.finalSettlementDate +
			'}' + " " + super.toString();
		}
	}
}
