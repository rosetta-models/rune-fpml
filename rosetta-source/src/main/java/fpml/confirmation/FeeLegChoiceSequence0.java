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
import fpml.confirmation.FeeLegChoiceSequence0;
import fpml.confirmation.FeeLegChoiceSequence0.FeeLegChoiceSequence0Builder;
import fpml.confirmation.FeeLegChoiceSequence0.FeeLegChoiceSequence0BuilderImpl;
import fpml.confirmation.FeeLegChoiceSequence0.FeeLegChoiceSequence0Impl;
import fpml.confirmation.InitialPayment;
import fpml.confirmation.PeriodicPayment;
import fpml.confirmation.meta.FeeLegChoiceSequence0Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FeeLegChoiceSequence0", builder=FeeLegChoiceSequence0.FeeLegChoiceSequence0BuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FeeLegChoiceSequence0 extends RosettaModelObject {

	FeeLegChoiceSequence0Meta metaData = new FeeLegChoiceSequence0Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies a single fixed payment that is payable by the payer to the receiver on the initial payment date. The fixed payment to be paid is specified in terms of a known currency amount. This element should be used for CDS Index trades, Standard CDS trades, and can be used for CDS trades where it is necessary to represent a payment from Seller to Buyer. For CDS trades where a payment is to be made from Buyer to Seller the feeLeg/singlePayment structure must be used.
	 */
	InitialPayment getInitialPayment();
	/**
	 * Specifies a periodic schedule of fixed amounts that are payable by the buyer to the seller on the fixed rate payer payment dates. The fixed amount to be paid on each payment date can be specified in terms of a known currency amount or as an amount calculated on a formula basis by reference to a per annum fixed rate. The applicable business day convention and business day for adjusting any fixed rate payer payment date if it would otherwise fall on a day that is not a business day are those specified in the dateAdjustments element within the generalTerms component. ISDA 2003 Term:
	 */
	PeriodicPayment getPeriodicPayment();

	/*********************** Build Methods  ***********************/
	FeeLegChoiceSequence0 build();
	
	FeeLegChoiceSequence0.FeeLegChoiceSequence0Builder toBuilder();
	
	static FeeLegChoiceSequence0.FeeLegChoiceSequence0Builder builder() {
		return new FeeLegChoiceSequence0.FeeLegChoiceSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FeeLegChoiceSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FeeLegChoiceSequence0> getType() {
		return FeeLegChoiceSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("initialPayment"), processor, InitialPayment.class, getInitialPayment());
		processRosetta(path.newSubPath("periodicPayment"), processor, PeriodicPayment.class, getPeriodicPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FeeLegChoiceSequence0Builder extends FeeLegChoiceSequence0, RosettaModelObjectBuilder {
		InitialPayment.InitialPaymentBuilder getOrCreateInitialPayment();
		InitialPayment.InitialPaymentBuilder getInitialPayment();
		PeriodicPayment.PeriodicPaymentBuilder getOrCreatePeriodicPayment();
		PeriodicPayment.PeriodicPaymentBuilder getPeriodicPayment();
		FeeLegChoiceSequence0.FeeLegChoiceSequence0Builder setInitialPayment(InitialPayment initialPayment);
		FeeLegChoiceSequence0.FeeLegChoiceSequence0Builder setPeriodicPayment(PeriodicPayment periodicPayment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("initialPayment"), processor, InitialPayment.InitialPaymentBuilder.class, getInitialPayment());
			processRosetta(path.newSubPath("periodicPayment"), processor, PeriodicPayment.PeriodicPaymentBuilder.class, getPeriodicPayment());
		}
		

		FeeLegChoiceSequence0.FeeLegChoiceSequence0Builder prune();
	}

	/*********************** Immutable Implementation of FeeLegChoiceSequence0  ***********************/
	class FeeLegChoiceSequence0Impl implements FeeLegChoiceSequence0 {
		private final InitialPayment initialPayment;
		private final PeriodicPayment periodicPayment;
		
		protected FeeLegChoiceSequence0Impl(FeeLegChoiceSequence0.FeeLegChoiceSequence0Builder builder) {
			this.initialPayment = ofNullable(builder.getInitialPayment()).map(f->f.build()).orElse(null);
			this.periodicPayment = ofNullable(builder.getPeriodicPayment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("initialPayment")
		public InitialPayment getInitialPayment() {
			return initialPayment;
		}
		
		@Override
		@RosettaAttribute("periodicPayment")
		public PeriodicPayment getPeriodicPayment() {
			return periodicPayment;
		}
		
		@Override
		public FeeLegChoiceSequence0 build() {
			return this;
		}
		
		@Override
		public FeeLegChoiceSequence0.FeeLegChoiceSequence0Builder toBuilder() {
			FeeLegChoiceSequence0.FeeLegChoiceSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FeeLegChoiceSequence0.FeeLegChoiceSequence0Builder builder) {
			ofNullable(getInitialPayment()).ifPresent(builder::setInitialPayment);
			ofNullable(getPeriodicPayment()).ifPresent(builder::setPeriodicPayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FeeLegChoiceSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(initialPayment, _that.getInitialPayment())) return false;
			if (!Objects.equals(periodicPayment, _that.getPeriodicPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialPayment != null ? initialPayment.hashCode() : 0);
			_result = 31 * _result + (periodicPayment != null ? periodicPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FeeLegChoiceSequence0 {" +
				"initialPayment=" + this.initialPayment + ", " +
				"periodicPayment=" + this.periodicPayment +
			'}';
		}
	}

	/*********************** Builder Implementation of FeeLegChoiceSequence0  ***********************/
	class FeeLegChoiceSequence0BuilderImpl implements FeeLegChoiceSequence0.FeeLegChoiceSequence0Builder {
	
		protected InitialPayment.InitialPaymentBuilder initialPayment;
		protected PeriodicPayment.PeriodicPaymentBuilder periodicPayment;
	
		public FeeLegChoiceSequence0BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("initialPayment")
		public InitialPayment.InitialPaymentBuilder getInitialPayment() {
			return initialPayment;
		}
		
		@Override
		public InitialPayment.InitialPaymentBuilder getOrCreateInitialPayment() {
			InitialPayment.InitialPaymentBuilder result;
			if (initialPayment!=null) {
				result = initialPayment;
			}
			else {
				result = initialPayment = InitialPayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("periodicPayment")
		public PeriodicPayment.PeriodicPaymentBuilder getPeriodicPayment() {
			return periodicPayment;
		}
		
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder getOrCreatePeriodicPayment() {
			PeriodicPayment.PeriodicPaymentBuilder result;
			if (periodicPayment!=null) {
				result = periodicPayment;
			}
			else {
				result = periodicPayment = PeriodicPayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialPayment")
		public FeeLegChoiceSequence0.FeeLegChoiceSequence0Builder setInitialPayment(InitialPayment initialPayment) {
			this.initialPayment = initialPayment==null?null:initialPayment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("periodicPayment")
		public FeeLegChoiceSequence0.FeeLegChoiceSequence0Builder setPeriodicPayment(PeriodicPayment periodicPayment) {
			this.periodicPayment = periodicPayment==null?null:periodicPayment.toBuilder();
			return this;
		}
		
		@Override
		public FeeLegChoiceSequence0 build() {
			return new FeeLegChoiceSequence0.FeeLegChoiceSequence0Impl(this);
		}
		
		@Override
		public FeeLegChoiceSequence0.FeeLegChoiceSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FeeLegChoiceSequence0.FeeLegChoiceSequence0Builder prune() {
			if (initialPayment!=null && !initialPayment.prune().hasData()) initialPayment = null;
			if (periodicPayment!=null && !periodicPayment.prune().hasData()) periodicPayment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInitialPayment()!=null && getInitialPayment().hasData()) return true;
			if (getPeriodicPayment()!=null && getPeriodicPayment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FeeLegChoiceSequence0.FeeLegChoiceSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FeeLegChoiceSequence0.FeeLegChoiceSequence0Builder o = (FeeLegChoiceSequence0.FeeLegChoiceSequence0Builder) other;
			
			merger.mergeRosetta(getInitialPayment(), o.getInitialPayment(), this::setInitialPayment);
			merger.mergeRosetta(getPeriodicPayment(), o.getPeriodicPayment(), this::setPeriodicPayment);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FeeLegChoiceSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(initialPayment, _that.getInitialPayment())) return false;
			if (!Objects.equals(periodicPayment, _that.getPeriodicPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialPayment != null ? initialPayment.hashCode() : 0);
			_result = 31 * _result + (periodicPayment != null ? periodicPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FeeLegChoiceSequence0Builder {" +
				"initialPayment=" + this.initialPayment + ", " +
				"periodicPayment=" + this.periodicPayment +
			'}';
		}
	}
}
