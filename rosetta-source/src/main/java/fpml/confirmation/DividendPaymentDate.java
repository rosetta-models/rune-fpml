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
import fpml.confirmation.DividendPaymentDate;
import fpml.confirmation.DividendPaymentDate.DividendPaymentDateBuilder;
import fpml.confirmation.DividendPaymentDate.DividendPaymentDateBuilderImpl;
import fpml.confirmation.DividendPaymentDate.DividendPaymentDateImpl;
import fpml.confirmation.DividendPaymentDateSequence;
import fpml.confirmation.meta.DividendPaymentDateMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing the date on which the dividend will be paid/received. This type is also used to specify the date on which the FX rate will be determined, when applicable.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="DividendPaymentDate", builder=DividendPaymentDate.DividendPaymentDateBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface DividendPaymentDate extends RosettaModelObject {

	DividendPaymentDateMeta metaData = new DividendPaymentDateMeta();

	/*********************** Getter Methods  ***********************/
	DividendPaymentDateSequence getDividendPaymentDateSequence();
	/**
	 * A date that shall be subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
	 */
	AdjustableDate getAdjustableDate();

	/*********************** Build Methods  ***********************/
	DividendPaymentDate build();
	
	DividendPaymentDate.DividendPaymentDateBuilder toBuilder();
	
	static DividendPaymentDate.DividendPaymentDateBuilder builder() {
		return new DividendPaymentDate.DividendPaymentDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DividendPaymentDate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DividendPaymentDate> getType() {
		return DividendPaymentDate.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dividendPaymentDateSequence"), processor, DividendPaymentDateSequence.class, getDividendPaymentDateSequence());
		processRosetta(path.newSubPath("adjustableDate"), processor, AdjustableDate.class, getAdjustableDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DividendPaymentDateBuilder extends DividendPaymentDate, RosettaModelObjectBuilder {
		DividendPaymentDateSequence.DividendPaymentDateSequenceBuilder getOrCreateDividendPaymentDateSequence();
		DividendPaymentDateSequence.DividendPaymentDateSequenceBuilder getDividendPaymentDateSequence();
		AdjustableDate.AdjustableDateBuilder getOrCreateAdjustableDate();
		AdjustableDate.AdjustableDateBuilder getAdjustableDate();
		DividendPaymentDate.DividendPaymentDateBuilder setDividendPaymentDateSequence(DividendPaymentDateSequence dividendPaymentDateSequence);
		DividendPaymentDate.DividendPaymentDateBuilder setAdjustableDate(AdjustableDate adjustableDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dividendPaymentDateSequence"), processor, DividendPaymentDateSequence.DividendPaymentDateSequenceBuilder.class, getDividendPaymentDateSequence());
			processRosetta(path.newSubPath("adjustableDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getAdjustableDate());
		}
		

		DividendPaymentDate.DividendPaymentDateBuilder prune();
	}

	/*********************** Immutable Implementation of DividendPaymentDate  ***********************/
	class DividendPaymentDateImpl implements DividendPaymentDate {
		private final DividendPaymentDateSequence dividendPaymentDateSequence;
		private final AdjustableDate adjustableDate;
		
		protected DividendPaymentDateImpl(DividendPaymentDate.DividendPaymentDateBuilder builder) {
			this.dividendPaymentDateSequence = ofNullable(builder.getDividendPaymentDateSequence()).map(f->f.build()).orElse(null);
			this.adjustableDate = ofNullable(builder.getAdjustableDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dividendPaymentDateSequence")
		public DividendPaymentDateSequence getDividendPaymentDateSequence() {
			return dividendPaymentDateSequence;
		}
		
		@Override
		@RosettaAttribute("adjustableDate")
		public AdjustableDate getAdjustableDate() {
			return adjustableDate;
		}
		
		@Override
		public DividendPaymentDate build() {
			return this;
		}
		
		@Override
		public DividendPaymentDate.DividendPaymentDateBuilder toBuilder() {
			DividendPaymentDate.DividendPaymentDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendPaymentDate.DividendPaymentDateBuilder builder) {
			ofNullable(getDividendPaymentDateSequence()).ifPresent(builder::setDividendPaymentDateSequence);
			ofNullable(getAdjustableDate()).ifPresent(builder::setAdjustableDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendPaymentDate _that = getType().cast(o);
		
			if (!Objects.equals(dividendPaymentDateSequence, _that.getDividendPaymentDateSequence())) return false;
			if (!Objects.equals(adjustableDate, _that.getAdjustableDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendPaymentDateSequence != null ? dividendPaymentDateSequence.hashCode() : 0);
			_result = 31 * _result + (adjustableDate != null ? adjustableDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPaymentDate {" +
				"dividendPaymentDateSequence=" + this.dividendPaymentDateSequence + ", " +
				"adjustableDate=" + this.adjustableDate +
			'}';
		}
	}

	/*********************** Builder Implementation of DividendPaymentDate  ***********************/
	class DividendPaymentDateBuilderImpl implements DividendPaymentDate.DividendPaymentDateBuilder {
	
		protected DividendPaymentDateSequence.DividendPaymentDateSequenceBuilder dividendPaymentDateSequence;
		protected AdjustableDate.AdjustableDateBuilder adjustableDate;
	
		public DividendPaymentDateBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dividendPaymentDateSequence")
		public DividendPaymentDateSequence.DividendPaymentDateSequenceBuilder getDividendPaymentDateSequence() {
			return dividendPaymentDateSequence;
		}
		
		@Override
		public DividendPaymentDateSequence.DividendPaymentDateSequenceBuilder getOrCreateDividendPaymentDateSequence() {
			DividendPaymentDateSequence.DividendPaymentDateSequenceBuilder result;
			if (dividendPaymentDateSequence!=null) {
				result = dividendPaymentDateSequence;
			}
			else {
				result = dividendPaymentDateSequence = DividendPaymentDateSequence.builder();
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
		@RosettaAttribute("dividendPaymentDateSequence")
		public DividendPaymentDate.DividendPaymentDateBuilder setDividendPaymentDateSequence(DividendPaymentDateSequence dividendPaymentDateSequence) {
			this.dividendPaymentDateSequence = dividendPaymentDateSequence==null?null:dividendPaymentDateSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("adjustableDate")
		public DividendPaymentDate.DividendPaymentDateBuilder setAdjustableDate(AdjustableDate adjustableDate) {
			this.adjustableDate = adjustableDate==null?null:adjustableDate.toBuilder();
			return this;
		}
		
		@Override
		public DividendPaymentDate build() {
			return new DividendPaymentDate.DividendPaymentDateImpl(this);
		}
		
		@Override
		public DividendPaymentDate.DividendPaymentDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPaymentDate.DividendPaymentDateBuilder prune() {
			if (dividendPaymentDateSequence!=null && !dividendPaymentDateSequence.prune().hasData()) dividendPaymentDateSequence = null;
			if (adjustableDate!=null && !adjustableDate.prune().hasData()) adjustableDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDividendPaymentDateSequence()!=null && getDividendPaymentDateSequence().hasData()) return true;
			if (getAdjustableDate()!=null && getAdjustableDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPaymentDate.DividendPaymentDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DividendPaymentDate.DividendPaymentDateBuilder o = (DividendPaymentDate.DividendPaymentDateBuilder) other;
			
			merger.mergeRosetta(getDividendPaymentDateSequence(), o.getDividendPaymentDateSequence(), this::setDividendPaymentDateSequence);
			merger.mergeRosetta(getAdjustableDate(), o.getAdjustableDate(), this::setAdjustableDate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendPaymentDate _that = getType().cast(o);
		
			if (!Objects.equals(dividendPaymentDateSequence, _that.getDividendPaymentDateSequence())) return false;
			if (!Objects.equals(adjustableDate, _that.getAdjustableDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendPaymentDateSequence != null ? dividendPaymentDateSequence.hashCode() : 0);
			_result = 31 * _result + (adjustableDate != null ? adjustableDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPaymentDateBuilder {" +
				"dividendPaymentDateSequence=" + this.dividendPaymentDateSequence + ", " +
				"adjustableDate=" + this.adjustableDate +
			'}';
		}
	}
}
