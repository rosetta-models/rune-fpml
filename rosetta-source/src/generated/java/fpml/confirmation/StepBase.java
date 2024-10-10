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
import fpml.confirmation.StepBase;
import fpml.confirmation.StepBase.StepBaseBuilder;
import fpml.confirmation.StepBase.StepBaseBuilderImpl;
import fpml.confirmation.StepBase.StepBaseImpl;
import fpml.confirmation.meta.StepBaseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a step date and step value pair. This step definitions are used to define varying rate or amount schedules, e.g. a notional amortization or a step-up coupon schedule.
 * @version ${project.version}
 */
@RosettaDataType(value="StepBase", builder=StepBase.StepBaseBuilderImpl.class, version="${project.version}")
public interface StepBase extends RosettaModelObject {

	StepBaseMeta metaData = new StepBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The date on which the associated stepValue becomes effective. This day may be subject to adjustment in accordance with a business day convention.
	 */
	Date getStepDate();
	String getId();

	/*********************** Build Methods  ***********************/
	StepBase build();
	
	StepBase.StepBaseBuilder toBuilder();
	
	static StepBase.StepBaseBuilder builder() {
		return new StepBase.StepBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends StepBase> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends StepBase> getType() {
		return StepBase.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("stepDate"), Date.class, getStepDate(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface StepBaseBuilder extends StepBase, RosettaModelObjectBuilder {
		StepBase.StepBaseBuilder setStepDate(Date stepDate);
		StepBase.StepBaseBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("stepDate"), Date.class, getStepDate(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		StepBase.StepBaseBuilder prune();
	}

	/*********************** Immutable Implementation of StepBase  ***********************/
	class StepBaseImpl implements StepBase {
		private final Date stepDate;
		private final String id;
		
		protected StepBaseImpl(StepBase.StepBaseBuilder builder) {
			this.stepDate = builder.getStepDate();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("stepDate")
		public Date getStepDate() {
			return stepDate;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public StepBase build() {
			return this;
		}
		
		@Override
		public StepBase.StepBaseBuilder toBuilder() {
			StepBase.StepBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StepBase.StepBaseBuilder builder) {
			ofNullable(getStepDate()).ifPresent(builder::setStepDate);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StepBase _that = getType().cast(o);
		
			if (!Objects.equals(stepDate, _that.getStepDate())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (stepDate != null ? stepDate.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StepBase {" +
				"stepDate=" + this.stepDate + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of StepBase  ***********************/
	class StepBaseBuilderImpl implements StepBase.StepBaseBuilder {
	
		protected Date stepDate;
		protected String id;
	
		public StepBaseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("stepDate")
		public Date getStepDate() {
			return stepDate;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("stepDate")
		public StepBase.StepBaseBuilder setStepDate(Date stepDate) {
			this.stepDate = stepDate==null?null:stepDate;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public StepBase.StepBaseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public StepBase build() {
			return new StepBase.StepBaseImpl(this);
		}
		
		@Override
		public StepBase.StepBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StepBase.StepBaseBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStepDate()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StepBase.StepBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			StepBase.StepBaseBuilder o = (StepBase.StepBaseBuilder) other;
			
			
			merger.mergeBasic(getStepDate(), o.getStepDate(), this::setStepDate);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StepBase _that = getType().cast(o);
		
			if (!Objects.equals(stepDate, _that.getStepDate())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (stepDate != null ? stepDate.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StepBaseBuilder {" +
				"stepDate=" + this.stepDate + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
