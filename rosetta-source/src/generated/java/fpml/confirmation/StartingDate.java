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
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.DateReference;
import fpml.confirmation.StartingDate;
import fpml.confirmation.StartingDate.StartingDateBuilder;
import fpml.confirmation.StartingDate.StartingDateBuilderImpl;
import fpml.confirmation.StartingDate.StartingDateImpl;
import fpml.confirmation.meta.StartingDateMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type specifying the date from which the early termination clause can be exercised.
 * @version ${project.version}
 */
@RosettaDataType(value="StartingDate", builder=StartingDate.StartingDateBuilderImpl.class, version="${project.version}")
public interface StartingDate extends RosettaModelObject {

	StartingDateMeta metaData = new StartingDateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Reference to a date defined elswhere in the document.
	 */
	DateReference getDateRelativeTo();
	/**
	 * Date from which early termination clause can be exercised.
	 */
	AdjustableDate getAdjustableDate();

	/*********************** Build Methods  ***********************/
	StartingDate build();
	
	StartingDate.StartingDateBuilder toBuilder();
	
	static StartingDate.StartingDateBuilder builder() {
		return new StartingDate.StartingDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends StartingDate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends StartingDate> getType() {
		return StartingDate.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dateRelativeTo"), processor, DateReference.class, getDateRelativeTo());
		processRosetta(path.newSubPath("adjustableDate"), processor, AdjustableDate.class, getAdjustableDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface StartingDateBuilder extends StartingDate, RosettaModelObjectBuilder {
		DateReference.DateReferenceBuilder getOrCreateDateRelativeTo();
		DateReference.DateReferenceBuilder getDateRelativeTo();
		AdjustableDate.AdjustableDateBuilder getOrCreateAdjustableDate();
		AdjustableDate.AdjustableDateBuilder getAdjustableDate();
		StartingDate.StartingDateBuilder setDateRelativeTo(DateReference dateRelativeTo);
		StartingDate.StartingDateBuilder setAdjustableDate(AdjustableDate adjustableDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dateRelativeTo"), processor, DateReference.DateReferenceBuilder.class, getDateRelativeTo());
			processRosetta(path.newSubPath("adjustableDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getAdjustableDate());
		}
		

		StartingDate.StartingDateBuilder prune();
	}

	/*********************** Immutable Implementation of StartingDate  ***********************/
	class StartingDateImpl implements StartingDate {
		private final DateReference dateRelativeTo;
		private final AdjustableDate adjustableDate;
		
		protected StartingDateImpl(StartingDate.StartingDateBuilder builder) {
			this.dateRelativeTo = ofNullable(builder.getDateRelativeTo()).map(f->f.build()).orElse(null);
			this.adjustableDate = ofNullable(builder.getAdjustableDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dateRelativeTo")
		public DateReference getDateRelativeTo() {
			return dateRelativeTo;
		}
		
		@Override
		@RosettaAttribute("adjustableDate")
		public AdjustableDate getAdjustableDate() {
			return adjustableDate;
		}
		
		@Override
		public StartingDate build() {
			return this;
		}
		
		@Override
		public StartingDate.StartingDateBuilder toBuilder() {
			StartingDate.StartingDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StartingDate.StartingDateBuilder builder) {
			ofNullable(getDateRelativeTo()).ifPresent(builder::setDateRelativeTo);
			ofNullable(getAdjustableDate()).ifPresent(builder::setAdjustableDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StartingDate _that = getType().cast(o);
		
			if (!Objects.equals(dateRelativeTo, _that.getDateRelativeTo())) return false;
			if (!Objects.equals(adjustableDate, _that.getAdjustableDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateRelativeTo != null ? dateRelativeTo.hashCode() : 0);
			_result = 31 * _result + (adjustableDate != null ? adjustableDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StartingDate {" +
				"dateRelativeTo=" + this.dateRelativeTo + ", " +
				"adjustableDate=" + this.adjustableDate +
			'}';
		}
	}

	/*********************** Builder Implementation of StartingDate  ***********************/
	class StartingDateBuilderImpl implements StartingDate.StartingDateBuilder {
	
		protected DateReference.DateReferenceBuilder dateRelativeTo;
		protected AdjustableDate.AdjustableDateBuilder adjustableDate;
	
		public StartingDateBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dateRelativeTo")
		public DateReference.DateReferenceBuilder getDateRelativeTo() {
			return dateRelativeTo;
		}
		
		@Override
		public DateReference.DateReferenceBuilder getOrCreateDateRelativeTo() {
			DateReference.DateReferenceBuilder result;
			if (dateRelativeTo!=null) {
				result = dateRelativeTo;
			}
			else {
				result = dateRelativeTo = DateReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("adjustableDate")
		public AdjustableDate.AdjustableDateBuilder getAdjustableDate() {
			return adjustableDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreateAdjustableDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (adjustableDate!=null) {
				result = adjustableDate;
			}
			else {
				result = adjustableDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dateRelativeTo")
		public StartingDate.StartingDateBuilder setDateRelativeTo(DateReference dateRelativeTo) {
			this.dateRelativeTo = dateRelativeTo==null?null:dateRelativeTo.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("adjustableDate")
		public StartingDate.StartingDateBuilder setAdjustableDate(AdjustableDate adjustableDate) {
			this.adjustableDate = adjustableDate==null?null:adjustableDate.toBuilder();
			return this;
		}
		
		@Override
		public StartingDate build() {
			return new StartingDate.StartingDateImpl(this);
		}
		
		@Override
		public StartingDate.StartingDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StartingDate.StartingDateBuilder prune() {
			if (dateRelativeTo!=null && !dateRelativeTo.prune().hasData()) dateRelativeTo = null;
			if (adjustableDate!=null && !adjustableDate.prune().hasData()) adjustableDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDateRelativeTo()!=null && getDateRelativeTo().hasData()) return true;
			if (getAdjustableDate()!=null && getAdjustableDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StartingDate.StartingDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			StartingDate.StartingDateBuilder o = (StartingDate.StartingDateBuilder) other;
			
			merger.mergeRosetta(getDateRelativeTo(), o.getDateRelativeTo(), this::setDateRelativeTo);
			merger.mergeRosetta(getAdjustableDate(), o.getAdjustableDate(), this::setAdjustableDate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StartingDate _that = getType().cast(o);
		
			if (!Objects.equals(dateRelativeTo, _that.getDateRelativeTo())) return false;
			if (!Objects.equals(adjustableDate, _that.getAdjustableDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateRelativeTo != null ? dateRelativeTo.hashCode() : 0);
			_result = 31 * _result + (adjustableDate != null ? adjustableDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StartingDateBuilder {" +
				"dateRelativeTo=" + this.dateRelativeTo + ", " +
				"adjustableDate=" + this.adjustableDate +
			'}';
		}
	}
}
