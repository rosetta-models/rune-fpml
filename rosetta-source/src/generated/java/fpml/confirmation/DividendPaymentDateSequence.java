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
import fpml.confirmation.DividendDateReferenceEnum;
import fpml.confirmation.DividendPaymentDateSequence;
import fpml.confirmation.DividendPaymentDateSequence.DividendPaymentDateSequenceBuilder;
import fpml.confirmation.DividendPaymentDateSequence.DividendPaymentDateSequenceBuilderImpl;
import fpml.confirmation.DividendPaymentDateSequence.DividendPaymentDateSequenceImpl;
import fpml.confirmation.Offset;
import fpml.confirmation.meta.DividendPaymentDateSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="DividendPaymentDateSequence", builder=DividendPaymentDateSequence.DividendPaymentDateSequenceBuilderImpl.class, version="${project.version}")
public interface DividendPaymentDateSequence extends RosettaModelObject {

	DividendPaymentDateSequenceMeta metaData = new DividendPaymentDateSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specification of the dividend date using an enumeration, with values such as the pay date, the ex date or the record date.
	 */
	DividendDateReferenceEnum getDividendDateReference();
	/**
	 * Only to be used when SharePayment has been specified in the dividendDateReference element. The number of Currency Business Days following the day on which the Issuer of the Shares pays the relevant dividend to holders of record of the Shares.
	 */
	Offset getPaymentDateOffset();

	/*********************** Build Methods  ***********************/
	DividendPaymentDateSequence build();
	
	DividendPaymentDateSequence.DividendPaymentDateSequenceBuilder toBuilder();
	
	static DividendPaymentDateSequence.DividendPaymentDateSequenceBuilder builder() {
		return new DividendPaymentDateSequence.DividendPaymentDateSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DividendPaymentDateSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DividendPaymentDateSequence> getType() {
		return DividendPaymentDateSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("dividendDateReference"), DividendDateReferenceEnum.class, getDividendDateReference(), this);
		processRosetta(path.newSubPath("paymentDateOffset"), processor, Offset.class, getPaymentDateOffset());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DividendPaymentDateSequenceBuilder extends DividendPaymentDateSequence, RosettaModelObjectBuilder {
		Offset.OffsetBuilder getOrCreatePaymentDateOffset();
		Offset.OffsetBuilder getPaymentDateOffset();
		DividendPaymentDateSequence.DividendPaymentDateSequenceBuilder setDividendDateReference(DividendDateReferenceEnum dividendDateReference);
		DividendPaymentDateSequence.DividendPaymentDateSequenceBuilder setPaymentDateOffset(Offset paymentDateOffset);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("dividendDateReference"), DividendDateReferenceEnum.class, getDividendDateReference(), this);
			processRosetta(path.newSubPath("paymentDateOffset"), processor, Offset.OffsetBuilder.class, getPaymentDateOffset());
		}
		

		DividendPaymentDateSequence.DividendPaymentDateSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of DividendPaymentDateSequence  ***********************/
	class DividendPaymentDateSequenceImpl implements DividendPaymentDateSequence {
		private final DividendDateReferenceEnum dividendDateReference;
		private final Offset paymentDateOffset;
		
		protected DividendPaymentDateSequenceImpl(DividendPaymentDateSequence.DividendPaymentDateSequenceBuilder builder) {
			this.dividendDateReference = builder.getDividendDateReference();
			this.paymentDateOffset = ofNullable(builder.getPaymentDateOffset()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dividendDateReference")
		public DividendDateReferenceEnum getDividendDateReference() {
			return dividendDateReference;
		}
		
		@Override
		@RosettaAttribute("paymentDateOffset")
		public Offset getPaymentDateOffset() {
			return paymentDateOffset;
		}
		
		@Override
		public DividendPaymentDateSequence build() {
			return this;
		}
		
		@Override
		public DividendPaymentDateSequence.DividendPaymentDateSequenceBuilder toBuilder() {
			DividendPaymentDateSequence.DividendPaymentDateSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendPaymentDateSequence.DividendPaymentDateSequenceBuilder builder) {
			ofNullable(getDividendDateReference()).ifPresent(builder::setDividendDateReference);
			ofNullable(getPaymentDateOffset()).ifPresent(builder::setPaymentDateOffset);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendPaymentDateSequence _that = getType().cast(o);
		
			if (!Objects.equals(dividendDateReference, _that.getDividendDateReference())) return false;
			if (!Objects.equals(paymentDateOffset, _that.getPaymentDateOffset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendDateReference != null ? dividendDateReference.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (paymentDateOffset != null ? paymentDateOffset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPaymentDateSequence {" +
				"dividendDateReference=" + this.dividendDateReference + ", " +
				"paymentDateOffset=" + this.paymentDateOffset +
			'}';
		}
	}

	/*********************** Builder Implementation of DividendPaymentDateSequence  ***********************/
	class DividendPaymentDateSequenceBuilderImpl implements DividendPaymentDateSequence.DividendPaymentDateSequenceBuilder {
	
		protected DividendDateReferenceEnum dividendDateReference;
		protected Offset.OffsetBuilder paymentDateOffset;
	
		public DividendPaymentDateSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dividendDateReference")
		public DividendDateReferenceEnum getDividendDateReference() {
			return dividendDateReference;
		}
		
		@Override
		@RosettaAttribute("paymentDateOffset")
		public Offset.OffsetBuilder getPaymentDateOffset() {
			return paymentDateOffset;
		}
		
		@Override
		public Offset.OffsetBuilder getOrCreatePaymentDateOffset() {
			Offset.OffsetBuilder result;
			if (paymentDateOffset!=null) {
				result = paymentDateOffset;
			}
			else {
				result = paymentDateOffset = Offset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dividendDateReference")
		public DividendPaymentDateSequence.DividendPaymentDateSequenceBuilder setDividendDateReference(DividendDateReferenceEnum dividendDateReference) {
			this.dividendDateReference = dividendDateReference==null?null:dividendDateReference;
			return this;
		}
		@Override
		@RosettaAttribute("paymentDateOffset")
		public DividendPaymentDateSequence.DividendPaymentDateSequenceBuilder setPaymentDateOffset(Offset paymentDateOffset) {
			this.paymentDateOffset = paymentDateOffset==null?null:paymentDateOffset.toBuilder();
			return this;
		}
		
		@Override
		public DividendPaymentDateSequence build() {
			return new DividendPaymentDateSequence.DividendPaymentDateSequenceImpl(this);
		}
		
		@Override
		public DividendPaymentDateSequence.DividendPaymentDateSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPaymentDateSequence.DividendPaymentDateSequenceBuilder prune() {
			if (paymentDateOffset!=null && !paymentDateOffset.prune().hasData()) paymentDateOffset = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDividendDateReference()!=null) return true;
			if (getPaymentDateOffset()!=null && getPaymentDateOffset().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPaymentDateSequence.DividendPaymentDateSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DividendPaymentDateSequence.DividendPaymentDateSequenceBuilder o = (DividendPaymentDateSequence.DividendPaymentDateSequenceBuilder) other;
			
			merger.mergeRosetta(getPaymentDateOffset(), o.getPaymentDateOffset(), this::setPaymentDateOffset);
			
			merger.mergeBasic(getDividendDateReference(), o.getDividendDateReference(), this::setDividendDateReference);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendPaymentDateSequence _that = getType().cast(o);
		
			if (!Objects.equals(dividendDateReference, _that.getDividendDateReference())) return false;
			if (!Objects.equals(paymentDateOffset, _that.getPaymentDateOffset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendDateReference != null ? dividendDateReference.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (paymentDateOffset != null ? paymentDateOffset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPaymentDateSequenceBuilder {" +
				"dividendDateReference=" + this.dividendDateReference + ", " +
				"paymentDateOffset=" + this.paymentDateOffset +
			'}';
		}
	}
}
