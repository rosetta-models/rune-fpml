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
import fpml.confirmation.DateReference;
import fpml.confirmation.DividendConditionsSequence;
import fpml.confirmation.DividendConditionsSequence.DividendConditionsSequenceBuilder;
import fpml.confirmation.DividendConditionsSequence.DividendConditionsSequenceBuilderImpl;
import fpml.confirmation.DividendConditionsSequence.DividendConditionsSequenceImpl;
import fpml.confirmation.meta.DividendConditionsSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="DividendConditionsSequence", builder=DividendConditionsSequence.DividendConditionsSequenceBuilderImpl.class, version="${project.version}")
public interface DividendConditionsSequence extends RosettaModelObject {

	DividendConditionsSequenceMeta metaData = new DividendConditionsSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Dividend period has the meaning as defined in the ISDA 2002 Equity Derivatives Definitions. This element specifies the date on which the dividend period will commence.
	 */
	DateReference getDividendPeriodEffectiveDate();
	/**
	 * Dividend period has the meaning as defined in the ISDA 2002 Equity Derivatives Definitions. This element specifies the date on which the dividend period will end. It includes a boolean attribute for defining whether this end date is included or excluded from the dividend period.
	 */
	DateReference getDividendPeriodEndDate();

	/*********************** Build Methods  ***********************/
	DividendConditionsSequence build();
	
	DividendConditionsSequence.DividendConditionsSequenceBuilder toBuilder();
	
	static DividendConditionsSequence.DividendConditionsSequenceBuilder builder() {
		return new DividendConditionsSequence.DividendConditionsSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DividendConditionsSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DividendConditionsSequence> getType() {
		return DividendConditionsSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dividendPeriodEffectiveDate"), processor, DateReference.class, getDividendPeriodEffectiveDate());
		processRosetta(path.newSubPath("dividendPeriodEndDate"), processor, DateReference.class, getDividendPeriodEndDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DividendConditionsSequenceBuilder extends DividendConditionsSequence, RosettaModelObjectBuilder {
		DateReference.DateReferenceBuilder getOrCreateDividendPeriodEffectiveDate();
		DateReference.DateReferenceBuilder getDividendPeriodEffectiveDate();
		DateReference.DateReferenceBuilder getOrCreateDividendPeriodEndDate();
		DateReference.DateReferenceBuilder getDividendPeriodEndDate();
		DividendConditionsSequence.DividendConditionsSequenceBuilder setDividendPeriodEffectiveDate(DateReference dividendPeriodEffectiveDate);
		DividendConditionsSequence.DividendConditionsSequenceBuilder setDividendPeriodEndDate(DateReference dividendPeriodEndDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dividendPeriodEffectiveDate"), processor, DateReference.DateReferenceBuilder.class, getDividendPeriodEffectiveDate());
			processRosetta(path.newSubPath("dividendPeriodEndDate"), processor, DateReference.DateReferenceBuilder.class, getDividendPeriodEndDate());
		}
		

		DividendConditionsSequence.DividendConditionsSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of DividendConditionsSequence  ***********************/
	class DividendConditionsSequenceImpl implements DividendConditionsSequence {
		private final DateReference dividendPeriodEffectiveDate;
		private final DateReference dividendPeriodEndDate;
		
		protected DividendConditionsSequenceImpl(DividendConditionsSequence.DividendConditionsSequenceBuilder builder) {
			this.dividendPeriodEffectiveDate = ofNullable(builder.getDividendPeriodEffectiveDate()).map(f->f.build()).orElse(null);
			this.dividendPeriodEndDate = ofNullable(builder.getDividendPeriodEndDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dividendPeriodEffectiveDate")
		public DateReference getDividendPeriodEffectiveDate() {
			return dividendPeriodEffectiveDate;
		}
		
		@Override
		@RosettaAttribute("dividendPeriodEndDate")
		public DateReference getDividendPeriodEndDate() {
			return dividendPeriodEndDate;
		}
		
		@Override
		public DividendConditionsSequence build() {
			return this;
		}
		
		@Override
		public DividendConditionsSequence.DividendConditionsSequenceBuilder toBuilder() {
			DividendConditionsSequence.DividendConditionsSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendConditionsSequence.DividendConditionsSequenceBuilder builder) {
			ofNullable(getDividendPeriodEffectiveDate()).ifPresent(builder::setDividendPeriodEffectiveDate);
			ofNullable(getDividendPeriodEndDate()).ifPresent(builder::setDividendPeriodEndDate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendConditionsSequence _that = getType().cast(o);
		
			if (!Objects.equals(dividendPeriodEffectiveDate, _that.getDividendPeriodEffectiveDate())) return false;
			if (!Objects.equals(dividendPeriodEndDate, _that.getDividendPeriodEndDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendPeriodEffectiveDate != null ? dividendPeriodEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (dividendPeriodEndDate != null ? dividendPeriodEndDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendConditionsSequence {" +
				"dividendPeriodEffectiveDate=" + this.dividendPeriodEffectiveDate + ", " +
				"dividendPeriodEndDate=" + this.dividendPeriodEndDate +
			'}';
		}
	}

	/*********************** Builder Implementation of DividendConditionsSequence  ***********************/
	class DividendConditionsSequenceBuilderImpl implements DividendConditionsSequence.DividendConditionsSequenceBuilder {
	
		protected DateReference.DateReferenceBuilder dividendPeriodEffectiveDate;
		protected DateReference.DateReferenceBuilder dividendPeriodEndDate;
	
		public DividendConditionsSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dividendPeriodEffectiveDate")
		public DateReference.DateReferenceBuilder getDividendPeriodEffectiveDate() {
			return dividendPeriodEffectiveDate;
		}
		
		@Override
		public DateReference.DateReferenceBuilder getOrCreateDividendPeriodEffectiveDate() {
			DateReference.DateReferenceBuilder result;
			if (dividendPeriodEffectiveDate!=null) {
				result = dividendPeriodEffectiveDate;
			}
			else {
				result = dividendPeriodEffectiveDate = DateReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dividendPeriodEndDate")
		public DateReference.DateReferenceBuilder getDividendPeriodEndDate() {
			return dividendPeriodEndDate;
		}
		
		@Override
		public DateReference.DateReferenceBuilder getOrCreateDividendPeriodEndDate() {
			DateReference.DateReferenceBuilder result;
			if (dividendPeriodEndDate!=null) {
				result = dividendPeriodEndDate;
			}
			else {
				result = dividendPeriodEndDate = DateReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dividendPeriodEffectiveDate")
		public DividendConditionsSequence.DividendConditionsSequenceBuilder setDividendPeriodEffectiveDate(DateReference dividendPeriodEffectiveDate) {
			this.dividendPeriodEffectiveDate = dividendPeriodEffectiveDate==null?null:dividendPeriodEffectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dividendPeriodEndDate")
		public DividendConditionsSequence.DividendConditionsSequenceBuilder setDividendPeriodEndDate(DateReference dividendPeriodEndDate) {
			this.dividendPeriodEndDate = dividendPeriodEndDate==null?null:dividendPeriodEndDate.toBuilder();
			return this;
		}
		
		@Override
		public DividendConditionsSequence build() {
			return new DividendConditionsSequence.DividendConditionsSequenceImpl(this);
		}
		
		@Override
		public DividendConditionsSequence.DividendConditionsSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendConditionsSequence.DividendConditionsSequenceBuilder prune() {
			if (dividendPeriodEffectiveDate!=null && !dividendPeriodEffectiveDate.prune().hasData()) dividendPeriodEffectiveDate = null;
			if (dividendPeriodEndDate!=null && !dividendPeriodEndDate.prune().hasData()) dividendPeriodEndDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDividendPeriodEffectiveDate()!=null && getDividendPeriodEffectiveDate().hasData()) return true;
			if (getDividendPeriodEndDate()!=null && getDividendPeriodEndDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendConditionsSequence.DividendConditionsSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DividendConditionsSequence.DividendConditionsSequenceBuilder o = (DividendConditionsSequence.DividendConditionsSequenceBuilder) other;
			
			merger.mergeRosetta(getDividendPeriodEffectiveDate(), o.getDividendPeriodEffectiveDate(), this::setDividendPeriodEffectiveDate);
			merger.mergeRosetta(getDividendPeriodEndDate(), o.getDividendPeriodEndDate(), this::setDividendPeriodEndDate);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendConditionsSequence _that = getType().cast(o);
		
			if (!Objects.equals(dividendPeriodEffectiveDate, _that.getDividendPeriodEffectiveDate())) return false;
			if (!Objects.equals(dividendPeriodEndDate, _that.getDividendPeriodEndDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendPeriodEffectiveDate != null ? dividendPeriodEffectiveDate.hashCode() : 0);
			_result = 31 * _result + (dividendPeriodEndDate != null ? dividendPeriodEndDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendConditionsSequenceBuilder {" +
				"dividendPeriodEffectiveDate=" + this.dividendPeriodEffectiveDate + ", " +
				"dividendPeriodEndDate=" + this.dividendPeriodEndDate +
			'}';
		}
	}
}
