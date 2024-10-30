package fpml.confirmation;

import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.FxScheduleSequence0;
import fpml.confirmation.FxScheduleSequence0.FxScheduleSequence0Builder;
import fpml.confirmation.FxScheduleSequence0.FxScheduleSequence0BuilderImpl;
import fpml.confirmation.FxScheduleSequence0.FxScheduleSequence0Impl;
import fpml.confirmation.meta.FxScheduleSequence0Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxScheduleSequence0", builder=FxScheduleSequence0.FxScheduleSequence0BuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxScheduleSequence0 extends RosettaModelObject {

	FxScheduleSequence0Meta metaData = new FxScheduleSequence0Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Date adjustments applied to the adjusted dates including the business day convention and the business centers.
	 */
	BusinessDayAdjustments getDateAdjustments();
	/**
	 * List of schedule dates. These dates have been subject to adjustments based on the dateAdjustments structure.
	 */
	List<Date> getAdjustedDate();

	/*********************** Build Methods  ***********************/
	FxScheduleSequence0 build();
	
	FxScheduleSequence0.FxScheduleSequence0Builder toBuilder();
	
	static FxScheduleSequence0.FxScheduleSequence0Builder builder() {
		return new FxScheduleSequence0.FxScheduleSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxScheduleSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxScheduleSequence0> getType() {
		return FxScheduleSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processor.processBasic(path.newSubPath("adjustedDate"), Date.class, getAdjustedDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxScheduleSequence0Builder extends FxScheduleSequence0, RosettaModelObjectBuilder {
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments();
		FxScheduleSequence0.FxScheduleSequence0Builder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		FxScheduleSequence0.FxScheduleSequence0Builder addAdjustedDate(Date adjustedDate0);
		FxScheduleSequence0.FxScheduleSequence0Builder addAdjustedDate(Date adjustedDate1, int _idx);
		FxScheduleSequence0.FxScheduleSequence0Builder addAdjustedDate(List<Date> adjustedDate2);
		FxScheduleSequence0.FxScheduleSequence0Builder setAdjustedDate(List<Date> adjustedDate3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processor.processBasic(path.newSubPath("adjustedDate"), Date.class, getAdjustedDate(), this);
		}
		

		FxScheduleSequence0.FxScheduleSequence0Builder prune();
	}

	/*********************** Immutable Implementation of FxScheduleSequence0  ***********************/
	class FxScheduleSequence0Impl implements FxScheduleSequence0 {
		private final BusinessDayAdjustments dateAdjustments;
		private final List<Date> adjustedDate;
		
		protected FxScheduleSequence0Impl(FxScheduleSequence0.FxScheduleSequence0Builder builder) {
			this.dateAdjustments = ofNullable(builder.getDateAdjustments()).map(f->f.build()).orElse(null);
			this.adjustedDate = ofNullable(builder.getAdjustedDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		public BusinessDayAdjustments getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		public List<Date> getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		public FxScheduleSequence0 build() {
			return this;
		}
		
		@Override
		public FxScheduleSequence0.FxScheduleSequence0Builder toBuilder() {
			FxScheduleSequence0.FxScheduleSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxScheduleSequence0.FxScheduleSequence0Builder builder) {
			ofNullable(getDateAdjustments()).ifPresent(builder::setDateAdjustments);
			ofNullable(getAdjustedDate()).ifPresent(builder::setAdjustedDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxScheduleSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!ListEquals.listEquals(adjustedDate, _that.getAdjustedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxScheduleSequence0 {" +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"adjustedDate=" + this.adjustedDate +
			'}';
		}
	}

	/*********************** Builder Implementation of FxScheduleSequence0  ***********************/
	class FxScheduleSequence0BuilderImpl implements FxScheduleSequence0.FxScheduleSequence0Builder {
	
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder dateAdjustments;
		protected List<Date> adjustedDate = new ArrayList<>();
	
		public FxScheduleSequence0BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dateAdjustments")
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (dateAdjustments!=null) {
				result = dateAdjustments;
			}
			else {
				result = dateAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		public List<Date> getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		public FxScheduleSequence0.FxScheduleSequence0Builder setDateAdjustments(BusinessDayAdjustments dateAdjustments) {
			this.dateAdjustments = dateAdjustments==null?null:dateAdjustments.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("adjustedDate")
		public FxScheduleSequence0.FxScheduleSequence0Builder addAdjustedDate(Date adjustedDate) {
			if (adjustedDate!=null) this.adjustedDate.add(adjustedDate);
			return this;
		}
		
		@Override
		public FxScheduleSequence0.FxScheduleSequence0Builder addAdjustedDate(Date adjustedDate, int _idx) {
			getIndex(this.adjustedDate, _idx, () -> adjustedDate);
			return this;
		}
		@Override 
		public FxScheduleSequence0.FxScheduleSequence0Builder addAdjustedDate(List<Date> adjustedDates) {
			if (adjustedDates != null) {
				for (Date toAdd : adjustedDates) {
					this.adjustedDate.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public FxScheduleSequence0.FxScheduleSequence0Builder setAdjustedDate(List<Date> adjustedDates) {
			if (adjustedDates == null)  {
				this.adjustedDate = new ArrayList<>();
			}
			else {
				this.adjustedDate = adjustedDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FxScheduleSequence0 build() {
			return new FxScheduleSequence0.FxScheduleSequence0Impl(this);
		}
		
		@Override
		public FxScheduleSequence0.FxScheduleSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxScheduleSequence0.FxScheduleSequence0Builder prune() {
			if (dateAdjustments!=null && !dateAdjustments.prune().hasData()) dateAdjustments = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDateAdjustments()!=null && getDateAdjustments().hasData()) return true;
			if (getAdjustedDate()!=null && !getAdjustedDate().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxScheduleSequence0.FxScheduleSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxScheduleSequence0.FxScheduleSequence0Builder o = (FxScheduleSequence0.FxScheduleSequence0Builder) other;
			
			merger.mergeRosetta(getDateAdjustments(), o.getDateAdjustments(), this::setDateAdjustments);
			
			merger.mergeBasic(getAdjustedDate(), o.getAdjustedDate(), (Consumer<Date>) this::addAdjustedDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxScheduleSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!ListEquals.listEquals(adjustedDate, _that.getAdjustedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxScheduleSequence0Builder {" +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"adjustedDate=" + this.adjustedDate +
			'}';
		}
	}
}
