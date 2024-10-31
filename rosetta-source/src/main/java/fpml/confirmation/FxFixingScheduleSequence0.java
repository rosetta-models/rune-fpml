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
import fpml.confirmation.FxFixingScheduleSequence0;
import fpml.confirmation.FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder;
import fpml.confirmation.FxFixingScheduleSequence0.FxFixingScheduleSequence0BuilderImpl;
import fpml.confirmation.FxFixingScheduleSequence0.FxFixingScheduleSequence0Impl;
import fpml.confirmation.meta.FxFixingScheduleSequence0Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxFixingScheduleSequence0", builder=FxFixingScheduleSequence0.FxFixingScheduleSequence0BuilderImpl.class, version="${project.version}")
public interface FxFixingScheduleSequence0 extends RosettaModelObject {

	FxFixingScheduleSequence0Meta metaData = new FxFixingScheduleSequence0Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Date adjustments applied to the adjusted dates including the business day convention and the business centers.
	 */
	BusinessDayAdjustments getDateAdjustments();
	/**
	 * List of schedule dates. These dates have been subject to adjustments based on the dateAdjustments structure.
	 */
	List<Date> getFixingDate();

	/*********************** Build Methods  ***********************/
	FxFixingScheduleSequence0 build();
	
	FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder toBuilder();
	
	static FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder builder() {
		return new FxFixingScheduleSequence0.FxFixingScheduleSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxFixingScheduleSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxFixingScheduleSequence0> getType() {
		return FxFixingScheduleSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processor.processBasic(path.newSubPath("fixingDate"), Date.class, getFixingDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxFixingScheduleSequence0Builder extends FxFixingScheduleSequence0, RosettaModelObjectBuilder {
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments();
		FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder addFixingDate(Date fixingDate0);
		FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder addFixingDate(Date fixingDate1, int _idx);
		FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder addFixingDate(List<Date> fixingDate2);
		FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder setFixingDate(List<Date> fixingDate3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processor.processBasic(path.newSubPath("fixingDate"), Date.class, getFixingDate(), this);
		}
		

		FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder prune();
	}

	/*********************** Immutable Implementation of FxFixingScheduleSequence0  ***********************/
	class FxFixingScheduleSequence0Impl implements FxFixingScheduleSequence0 {
		private final BusinessDayAdjustments dateAdjustments;
		private final List<Date> fixingDate;
		
		protected FxFixingScheduleSequence0Impl(FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder builder) {
			this.dateAdjustments = ofNullable(builder.getDateAdjustments()).map(f->f.build()).orElse(null);
			this.fixingDate = ofNullable(builder.getFixingDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		public BusinessDayAdjustments getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		@RosettaAttribute("fixingDate")
		public List<Date> getFixingDate() {
			return fixingDate;
		}
		
		@Override
		public FxFixingScheduleSequence0 build() {
			return this;
		}
		
		@Override
		public FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder toBuilder() {
			FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder builder) {
			ofNullable(getDateAdjustments()).ifPresent(builder::setDateAdjustments);
			ofNullable(getFixingDate()).ifPresent(builder::setFixingDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFixingScheduleSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!ListEquals.listEquals(fixingDate, _that.getFixingDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixingScheduleSequence0 {" +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"fixingDate=" + this.fixingDate +
			'}';
		}
	}

	/*********************** Builder Implementation of FxFixingScheduleSequence0  ***********************/
	class FxFixingScheduleSequence0BuilderImpl implements FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder {
	
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder dateAdjustments;
		protected List<Date> fixingDate = new ArrayList<>();
	
		public FxFixingScheduleSequence0BuilderImpl() {
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
		@RosettaAttribute("fixingDate")
		public List<Date> getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		public FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder setDateAdjustments(BusinessDayAdjustments dateAdjustments) {
			this.dateAdjustments = dateAdjustments==null?null:dateAdjustments.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixingDate")
		public FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder addFixingDate(Date fixingDate) {
			if (fixingDate!=null) this.fixingDate.add(fixingDate);
			return this;
		}
		
		@Override
		public FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder addFixingDate(Date fixingDate, int _idx) {
			getIndex(this.fixingDate, _idx, () -> fixingDate);
			return this;
		}
		@Override 
		public FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder addFixingDate(List<Date> fixingDates) {
			if (fixingDates != null) {
				for (Date toAdd : fixingDates) {
					this.fixingDate.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder setFixingDate(List<Date> fixingDates) {
			if (fixingDates == null)  {
				this.fixingDate = new ArrayList<>();
			}
			else {
				this.fixingDate = fixingDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FxFixingScheduleSequence0 build() {
			return new FxFixingScheduleSequence0.FxFixingScheduleSequence0Impl(this);
		}
		
		@Override
		public FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder prune() {
			if (dateAdjustments!=null && !dateAdjustments.prune().hasData()) dateAdjustments = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDateAdjustments()!=null && getDateAdjustments().hasData()) return true;
			if (getFixingDate()!=null && !getFixingDate().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder o = (FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder) other;
			
			merger.mergeRosetta(getDateAdjustments(), o.getDateAdjustments(), this::setDateAdjustments);
			
			merger.mergeBasic(getFixingDate(), o.getFixingDate(), (Consumer<Date>) this::addFixingDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFixingScheduleSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!ListEquals.listEquals(fixingDate, _that.getFixingDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixingScheduleSequence0Builder {" +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"fixingDate=" + this.fixingDate +
			'}';
		}
	}
}
