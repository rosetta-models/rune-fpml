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
import fpml.confirmation.Period;
import fpml.confirmation.TimeDimensionSequence;
import fpml.confirmation.TimeDimensionSequence.TimeDimensionSequenceBuilder;
import fpml.confirmation.TimeDimensionSequence.TimeDimensionSequenceBuilderImpl;
import fpml.confirmation.TimeDimensionSequence.TimeDimensionSequenceImpl;
import fpml.confirmation.meta.TimeDimensionSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TimeDimensionSequence", builder=TimeDimensionSequence.TimeDimensionSequenceBuilderImpl.class, version="${project.version}")
public interface TimeDimensionSequence extends RosettaModelObject {

	TimeDimensionSequenceMeta metaData = new TimeDimensionSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The absolute date corresponding to this term point, for example January 3, 2005.
	 */
	Date getDate();
	/**
	 * The amount of time from the base date of the pricing input to the specified term point, e.g. 6M or 5Y.
	 */
	Period getTenor();

	/*********************** Build Methods  ***********************/
	TimeDimensionSequence build();
	
	TimeDimensionSequence.TimeDimensionSequenceBuilder toBuilder();
	
	static TimeDimensionSequence.TimeDimensionSequenceBuilder builder() {
		return new TimeDimensionSequence.TimeDimensionSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TimeDimensionSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TimeDimensionSequence> getType() {
		return TimeDimensionSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
		processRosetta(path.newSubPath("tenor"), processor, Period.class, getTenor());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TimeDimensionSequenceBuilder extends TimeDimensionSequence, RosettaModelObjectBuilder {
		Period.PeriodBuilder getOrCreateTenor();
		Period.PeriodBuilder getTenor();
		TimeDimensionSequence.TimeDimensionSequenceBuilder setDate(Date date);
		TimeDimensionSequence.TimeDimensionSequenceBuilder setTenor(Period tenor);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
			processRosetta(path.newSubPath("tenor"), processor, Period.PeriodBuilder.class, getTenor());
		}
		

		TimeDimensionSequence.TimeDimensionSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of TimeDimensionSequence  ***********************/
	class TimeDimensionSequenceImpl implements TimeDimensionSequence {
		private final Date date;
		private final Period tenor;
		
		protected TimeDimensionSequenceImpl(TimeDimensionSequence.TimeDimensionSequenceBuilder builder) {
			this.date = builder.getDate();
			this.tenor = ofNullable(builder.getTenor()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("tenor")
		public Period getTenor() {
			return tenor;
		}
		
		@Override
		public TimeDimensionSequence build() {
			return this;
		}
		
		@Override
		public TimeDimensionSequence.TimeDimensionSequenceBuilder toBuilder() {
			TimeDimensionSequence.TimeDimensionSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TimeDimensionSequence.TimeDimensionSequenceBuilder builder) {
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getTenor()).ifPresent(builder::setTenor);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TimeDimensionSequence _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(tenor, _that.getTenor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (tenor != null ? tenor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TimeDimensionSequence {" +
				"date=" + this.date + ", " +
				"tenor=" + this.tenor +
			'}';
		}
	}

	/*********************** Builder Implementation of TimeDimensionSequence  ***********************/
	class TimeDimensionSequenceBuilderImpl implements TimeDimensionSequence.TimeDimensionSequenceBuilder {
	
		protected Date date;
		protected Period.PeriodBuilder tenor;
	
		public TimeDimensionSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("tenor")
		public Period.PeriodBuilder getTenor() {
			return tenor;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateTenor() {
			Period.PeriodBuilder result;
			if (tenor!=null) {
				result = tenor;
			}
			else {
				result = tenor = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("date")
		public TimeDimensionSequence.TimeDimensionSequenceBuilder setDate(Date date) {
			this.date = date==null?null:date;
			return this;
		}
		@Override
		@RosettaAttribute("tenor")
		public TimeDimensionSequence.TimeDimensionSequenceBuilder setTenor(Period tenor) {
			this.tenor = tenor==null?null:tenor.toBuilder();
			return this;
		}
		
		@Override
		public TimeDimensionSequence build() {
			return new TimeDimensionSequence.TimeDimensionSequenceImpl(this);
		}
		
		@Override
		public TimeDimensionSequence.TimeDimensionSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TimeDimensionSequence.TimeDimensionSequenceBuilder prune() {
			if (tenor!=null && !tenor.prune().hasData()) tenor = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDate()!=null) return true;
			if (getTenor()!=null && getTenor().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TimeDimensionSequence.TimeDimensionSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TimeDimensionSequence.TimeDimensionSequenceBuilder o = (TimeDimensionSequence.TimeDimensionSequenceBuilder) other;
			
			merger.mergeRosetta(getTenor(), o.getTenor(), this::setTenor);
			
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TimeDimensionSequence _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(tenor, _that.getTenor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (tenor != null ? tenor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TimeDimensionSequenceBuilder {" +
				"date=" + this.date + ", " +
				"tenor=" + this.tenor +
			'}';
		}
	}
}
