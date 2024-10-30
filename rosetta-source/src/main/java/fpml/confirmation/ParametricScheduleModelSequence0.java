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
import fpml.confirmation.ParametricScheduleModelSequence0;
import fpml.confirmation.ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Builder;
import fpml.confirmation.ParametricScheduleModelSequence0.ParametricScheduleModelSequence0BuilderImpl;
import fpml.confirmation.ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Impl;
import fpml.confirmation.meta.ParametricScheduleModelSequence0Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ParametricScheduleModelSequence0", builder=ParametricScheduleModelSequence0.ParametricScheduleModelSequence0BuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ParametricScheduleModelSequence0 extends RosettaModelObject {

	ParametricScheduleModelSequence0Meta metaData = new ParametricScheduleModelSequence0Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Start of the schedule.
	 */
	Date getStartDate();
	/**
	 * End of the schedule.
	 */
	Date getEndDate();

	/*********************** Build Methods  ***********************/
	ParametricScheduleModelSequence0 build();
	
	ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Builder toBuilder();
	
	static ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Builder builder() {
		return new ParametricScheduleModelSequence0.ParametricScheduleModelSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ParametricScheduleModelSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ParametricScheduleModelSequence0> getType() {
		return ParametricScheduleModelSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ParametricScheduleModelSequence0Builder extends ParametricScheduleModelSequence0, RosettaModelObjectBuilder {
		ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Builder setStartDate(Date startDate);
		ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Builder setEndDate(Date endDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
		}
		

		ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Builder prune();
	}

	/*********************** Immutable Implementation of ParametricScheduleModelSequence0  ***********************/
	class ParametricScheduleModelSequence0Impl implements ParametricScheduleModelSequence0 {
		private final Date startDate;
		private final Date endDate;
		
		protected ParametricScheduleModelSequence0Impl(ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Builder builder) {
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
		}
		
		@Override
		@RosettaAttribute("startDate")
		public Date getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		public Date getEndDate() {
			return endDate;
		}
		
		@Override
		public ParametricScheduleModelSequence0 build() {
			return this;
		}
		
		@Override
		public ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Builder toBuilder() {
			ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Builder builder) {
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ParametricScheduleModelSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ParametricScheduleModelSequence0 {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate +
			'}';
		}
	}

	/*********************** Builder Implementation of ParametricScheduleModelSequence0  ***********************/
	class ParametricScheduleModelSequence0BuilderImpl implements ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Builder {
	
		protected Date startDate;
		protected Date endDate;
	
		public ParametricScheduleModelSequence0BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("startDate")
		public Date getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		public Date getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("startDate")
		public ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Builder setStartDate(Date startDate) {
			this.startDate = startDate==null?null:startDate;
			return this;
		}
		@Override
		@RosettaAttribute("endDate")
		public ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Builder setEndDate(Date endDate) {
			this.endDate = endDate==null?null:endDate;
			return this;
		}
		
		@Override
		public ParametricScheduleModelSequence0 build() {
			return new ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Impl(this);
		}
		
		@Override
		public ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStartDate()!=null) return true;
			if (getEndDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Builder o = (ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Builder) other;
			
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ParametricScheduleModelSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ParametricScheduleModelSequence0Builder {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate +
			'}';
		}
	}
}
