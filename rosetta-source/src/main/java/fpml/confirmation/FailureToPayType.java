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
import fpml.confirmation.FailureToPayType;
import fpml.confirmation.FailureToPayType.FailureToPayTypeBuilder;
import fpml.confirmation.FailureToPayType.FailureToPayTypeBuilderImpl;
import fpml.confirmation.FailureToPayType.FailureToPayTypeImpl;
import fpml.confirmation.GracePeriodExtension;
import fpml.confirmation.Money;
import fpml.confirmation.meta.FailureToPayTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FailureToPayType", builder=FailureToPayType.FailureToPayTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FailureToPayType extends RosettaModelObject {

	FailureToPayTypeMeta metaData = new FailureToPayTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates whether the failure to pay provision is applicable.
	 */
	Boolean getApplicable();
	/**
	 * If this element is specified, indicates whether or not a grace period extension is applicable. ISDA 2003 Term: Grace Period Extension Applicable.
	 */
	GracePeriodExtension getGracePeriodExtension();
	/**
	 * Specifies a threshold for the failure to pay credit event. Market standard is USD 1,000,000 (JPY 100,000,000 for Japanese Yen trades) or its equivalent in the relevant obligation currency. This is applied on an aggregate basis across all Obligations of the Reference Entity. Intended to prevent technical/operational errors from triggering credit events. ISDA 2003 Term: Payment Requirement.
	 */
	Money getPaymentRequirement();

	/*********************** Build Methods  ***********************/
	FailureToPayType build();
	
	FailureToPayType.FailureToPayTypeBuilder toBuilder();
	
	static FailureToPayType.FailureToPayTypeBuilder builder() {
		return new FailureToPayType.FailureToPayTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FailureToPayType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FailureToPayType> getType() {
		return FailureToPayType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
		processRosetta(path.newSubPath("gracePeriodExtension"), processor, GracePeriodExtension.class, getGracePeriodExtension());
		processRosetta(path.newSubPath("paymentRequirement"), processor, Money.class, getPaymentRequirement());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FailureToPayTypeBuilder extends FailureToPayType, RosettaModelObjectBuilder {
		GracePeriodExtension.GracePeriodExtensionBuilder getOrCreateGracePeriodExtension();
		GracePeriodExtension.GracePeriodExtensionBuilder getGracePeriodExtension();
		Money.MoneyBuilder getOrCreatePaymentRequirement();
		Money.MoneyBuilder getPaymentRequirement();
		FailureToPayType.FailureToPayTypeBuilder setApplicable(Boolean applicable);
		FailureToPayType.FailureToPayTypeBuilder setGracePeriodExtension(GracePeriodExtension gracePeriodExtension);
		FailureToPayType.FailureToPayTypeBuilder setPaymentRequirement(Money paymentRequirement);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
			processRosetta(path.newSubPath("gracePeriodExtension"), processor, GracePeriodExtension.GracePeriodExtensionBuilder.class, getGracePeriodExtension());
			processRosetta(path.newSubPath("paymentRequirement"), processor, Money.MoneyBuilder.class, getPaymentRequirement());
		}
		

		FailureToPayType.FailureToPayTypeBuilder prune();
	}

	/*********************** Immutable Implementation of FailureToPayType  ***********************/
	class FailureToPayTypeImpl implements FailureToPayType {
		private final Boolean applicable;
		private final GracePeriodExtension gracePeriodExtension;
		private final Money paymentRequirement;
		
		protected FailureToPayTypeImpl(FailureToPayType.FailureToPayTypeBuilder builder) {
			this.applicable = builder.getApplicable();
			this.gracePeriodExtension = ofNullable(builder.getGracePeriodExtension()).map(f->f.build()).orElse(null);
			this.paymentRequirement = ofNullable(builder.getPaymentRequirement()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("gracePeriodExtension")
		public GracePeriodExtension getGracePeriodExtension() {
			return gracePeriodExtension;
		}
		
		@Override
		@RosettaAttribute("paymentRequirement")
		public Money getPaymentRequirement() {
			return paymentRequirement;
		}
		
		@Override
		public FailureToPayType build() {
			return this;
		}
		
		@Override
		public FailureToPayType.FailureToPayTypeBuilder toBuilder() {
			FailureToPayType.FailureToPayTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FailureToPayType.FailureToPayTypeBuilder builder) {
			ofNullable(getApplicable()).ifPresent(builder::setApplicable);
			ofNullable(getGracePeriodExtension()).ifPresent(builder::setGracePeriodExtension);
			ofNullable(getPaymentRequirement()).ifPresent(builder::setPaymentRequirement);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FailureToPayType _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(gracePeriodExtension, _that.getGracePeriodExtension())) return false;
			if (!Objects.equals(paymentRequirement, _that.getPaymentRequirement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (gracePeriodExtension != null ? gracePeriodExtension.hashCode() : 0);
			_result = 31 * _result + (paymentRequirement != null ? paymentRequirement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FailureToPayType {" +
				"applicable=" + this.applicable + ", " +
				"gracePeriodExtension=" + this.gracePeriodExtension + ", " +
				"paymentRequirement=" + this.paymentRequirement +
			'}';
		}
	}

	/*********************** Builder Implementation of FailureToPayType  ***********************/
	class FailureToPayTypeBuilderImpl implements FailureToPayType.FailureToPayTypeBuilder {
	
		protected Boolean applicable;
		protected GracePeriodExtension.GracePeriodExtensionBuilder gracePeriodExtension;
		protected Money.MoneyBuilder paymentRequirement;
	
		public FailureToPayTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("gracePeriodExtension")
		public GracePeriodExtension.GracePeriodExtensionBuilder getGracePeriodExtension() {
			return gracePeriodExtension;
		}
		
		@Override
		public GracePeriodExtension.GracePeriodExtensionBuilder getOrCreateGracePeriodExtension() {
			GracePeriodExtension.GracePeriodExtensionBuilder result;
			if (gracePeriodExtension!=null) {
				result = gracePeriodExtension;
			}
			else {
				result = gracePeriodExtension = GracePeriodExtension.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentRequirement")
		public Money.MoneyBuilder getPaymentRequirement() {
			return paymentRequirement;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreatePaymentRequirement() {
			Money.MoneyBuilder result;
			if (paymentRequirement!=null) {
				result = paymentRequirement;
			}
			else {
				result = paymentRequirement = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("applicable")
		public FailureToPayType.FailureToPayTypeBuilder setApplicable(Boolean applicable) {
			this.applicable = applicable==null?null:applicable;
			return this;
		}
		@Override
		@RosettaAttribute("gracePeriodExtension")
		public FailureToPayType.FailureToPayTypeBuilder setGracePeriodExtension(GracePeriodExtension gracePeriodExtension) {
			this.gracePeriodExtension = gracePeriodExtension==null?null:gracePeriodExtension.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentRequirement")
		public FailureToPayType.FailureToPayTypeBuilder setPaymentRequirement(Money paymentRequirement) {
			this.paymentRequirement = paymentRequirement==null?null:paymentRequirement.toBuilder();
			return this;
		}
		
		@Override
		public FailureToPayType build() {
			return new FailureToPayType.FailureToPayTypeImpl(this);
		}
		
		@Override
		public FailureToPayType.FailureToPayTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FailureToPayType.FailureToPayTypeBuilder prune() {
			if (gracePeriodExtension!=null && !gracePeriodExtension.prune().hasData()) gracePeriodExtension = null;
			if (paymentRequirement!=null && !paymentRequirement.prune().hasData()) paymentRequirement = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApplicable()!=null) return true;
			if (getGracePeriodExtension()!=null && getGracePeriodExtension().hasData()) return true;
			if (getPaymentRequirement()!=null && getPaymentRequirement().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FailureToPayType.FailureToPayTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FailureToPayType.FailureToPayTypeBuilder o = (FailureToPayType.FailureToPayTypeBuilder) other;
			
			merger.mergeRosetta(getGracePeriodExtension(), o.getGracePeriodExtension(), this::setGracePeriodExtension);
			merger.mergeRosetta(getPaymentRequirement(), o.getPaymentRequirement(), this::setPaymentRequirement);
			
			merger.mergeBasic(getApplicable(), o.getApplicable(), this::setApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FailureToPayType _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(gracePeriodExtension, _that.getGracePeriodExtension())) return false;
			if (!Objects.equals(paymentRequirement, _that.getPaymentRequirement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (gracePeriodExtension != null ? gracePeriodExtension.hashCode() : 0);
			_result = 31 * _result + (paymentRequirement != null ? paymentRequirement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FailureToPayTypeBuilder {" +
				"applicable=" + this.applicable + ", " +
				"gracePeriodExtension=" + this.gracePeriodExtension + ", " +
				"paymentRequirement=" + this.paymentRequirement +
			'}';
		}
	}
}
