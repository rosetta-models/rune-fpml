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
import fpml.confirmation.FxAccrualRegionSequence0;
import fpml.confirmation.FxAccrualRegionSequence0.FxAccrualRegionSequence0Builder;
import fpml.confirmation.FxAccrualRegionSequence0.FxAccrualRegionSequence0BuilderImpl;
import fpml.confirmation.FxAccrualRegionSequence0.FxAccrualRegionSequence0Impl;
import fpml.confirmation.meta.FxAccrualRegionSequence0Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxAccrualRegionSequence0", builder=FxAccrualRegionSequence0.FxAccrualRegionSequence0BuilderImpl.class, version="${project.version}")
public interface FxAccrualRegionSequence0 extends RosettaModelObject {

	FxAccrualRegionSequence0Meta metaData = new FxAccrualRegionSequence0Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the end date of the observation period for the barrier. If omitted, the last barrier observation point is understood to be the last fixing date in the fixing schedule.
	 */
	Date getStartDate();
	/**
	 * Defines the end date of the observation period for the barrier. If omitted, the last barrier observation point is understood to be the last fixing date in the fixing schedule.
	 */
	Date getEndDate();

	/*********************** Build Methods  ***********************/
	FxAccrualRegionSequence0 build();
	
	FxAccrualRegionSequence0.FxAccrualRegionSequence0Builder toBuilder();
	
	static FxAccrualRegionSequence0.FxAccrualRegionSequence0Builder builder() {
		return new FxAccrualRegionSequence0.FxAccrualRegionSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualRegionSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualRegionSequence0> getType() {
		return FxAccrualRegionSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualRegionSequence0Builder extends FxAccrualRegionSequence0, RosettaModelObjectBuilder {
		FxAccrualRegionSequence0.FxAccrualRegionSequence0Builder setStartDate(Date startDate);
		FxAccrualRegionSequence0.FxAccrualRegionSequence0Builder setEndDate(Date endDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
		}
		

		FxAccrualRegionSequence0.FxAccrualRegionSequence0Builder prune();
	}

	/*********************** Immutable Implementation of FxAccrualRegionSequence0  ***********************/
	class FxAccrualRegionSequence0Impl implements FxAccrualRegionSequence0 {
		private final Date startDate;
		private final Date endDate;
		
		protected FxAccrualRegionSequence0Impl(FxAccrualRegionSequence0.FxAccrualRegionSequence0Builder builder) {
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
		public FxAccrualRegionSequence0 build() {
			return this;
		}
		
		@Override
		public FxAccrualRegionSequence0.FxAccrualRegionSequence0Builder toBuilder() {
			FxAccrualRegionSequence0.FxAccrualRegionSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualRegionSequence0.FxAccrualRegionSequence0Builder builder) {
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualRegionSequence0 _that = getType().cast(o);
		
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
			return "FxAccrualRegionSequence0 {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAccrualRegionSequence0  ***********************/
	class FxAccrualRegionSequence0BuilderImpl implements FxAccrualRegionSequence0.FxAccrualRegionSequence0Builder {
	
		protected Date startDate;
		protected Date endDate;
	
		public FxAccrualRegionSequence0BuilderImpl() {
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
		public FxAccrualRegionSequence0.FxAccrualRegionSequence0Builder setStartDate(Date startDate) {
			this.startDate = startDate==null?null:startDate;
			return this;
		}
		@Override
		@RosettaAttribute("endDate")
		public FxAccrualRegionSequence0.FxAccrualRegionSequence0Builder setEndDate(Date endDate) {
			this.endDate = endDate==null?null:endDate;
			return this;
		}
		
		@Override
		public FxAccrualRegionSequence0 build() {
			return new FxAccrualRegionSequence0.FxAccrualRegionSequence0Impl(this);
		}
		
		@Override
		public FxAccrualRegionSequence0.FxAccrualRegionSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualRegionSequence0.FxAccrualRegionSequence0Builder prune() {
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
		public FxAccrualRegionSequence0.FxAccrualRegionSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAccrualRegionSequence0.FxAccrualRegionSequence0Builder o = (FxAccrualRegionSequence0.FxAccrualRegionSequence0Builder) other;
			
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualRegionSequence0 _that = getType().cast(o);
		
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
			return "FxAccrualRegionSequence0Builder {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate +
			'}';
		}
	}
}
