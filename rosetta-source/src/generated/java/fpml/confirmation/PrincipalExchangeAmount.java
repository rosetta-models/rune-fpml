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
import fpml.confirmation.AmountReference;
import fpml.confirmation.DeterminationMethod;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.PrincipalExchangeAmount;
import fpml.confirmation.PrincipalExchangeAmount.PrincipalExchangeAmountBuilder;
import fpml.confirmation.PrincipalExchangeAmount.PrincipalExchangeAmountBuilderImpl;
import fpml.confirmation.PrincipalExchangeAmount.PrincipalExchangeAmountImpl;
import fpml.confirmation.meta.PrincipalExchangeAmountMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the principal exchange amount, either by explicitly defining it, or by point to an amount defined somewhere else in the swap document.
 * @version ${project.version}
 */
@RosettaDataType(value="PrincipalExchangeAmount", builder=PrincipalExchangeAmount.PrincipalExchangeAmountBuilderImpl.class, version="${project.version}")
public interface PrincipalExchangeAmount extends RosettaModelObject {

	PrincipalExchangeAmountMeta metaData = new PrincipalExchangeAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Reference to an amount defined elsewhere in the document.
	 */
	AmountReference getAmountRelativeTo();
	/**
	 * Specifies the method according to which an amount or a date is determined.
	 */
	DeterminationMethod getDeterminationMethod();
	/**
	 * Principal exchange amount when explictly stated.
	 */
	NonNegativeMoney getPrincipalAmount();

	/*********************** Build Methods  ***********************/
	PrincipalExchangeAmount build();
	
	PrincipalExchangeAmount.PrincipalExchangeAmountBuilder toBuilder();
	
	static PrincipalExchangeAmount.PrincipalExchangeAmountBuilder builder() {
		return new PrincipalExchangeAmount.PrincipalExchangeAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PrincipalExchangeAmount> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PrincipalExchangeAmount> getType() {
		return PrincipalExchangeAmount.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amountRelativeTo"), processor, AmountReference.class, getAmountRelativeTo());
		processRosetta(path.newSubPath("determinationMethod"), processor, DeterminationMethod.class, getDeterminationMethod());
		processRosetta(path.newSubPath("principalAmount"), processor, NonNegativeMoney.class, getPrincipalAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PrincipalExchangeAmountBuilder extends PrincipalExchangeAmount, RosettaModelObjectBuilder {
		AmountReference.AmountReferenceBuilder getOrCreateAmountRelativeTo();
		AmountReference.AmountReferenceBuilder getAmountRelativeTo();
		DeterminationMethod.DeterminationMethodBuilder getOrCreateDeterminationMethod();
		DeterminationMethod.DeterminationMethodBuilder getDeterminationMethod();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePrincipalAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getPrincipalAmount();
		PrincipalExchangeAmount.PrincipalExchangeAmountBuilder setAmountRelativeTo(AmountReference amountRelativeTo);
		PrincipalExchangeAmount.PrincipalExchangeAmountBuilder setDeterminationMethod(DeterminationMethod determinationMethod);
		PrincipalExchangeAmount.PrincipalExchangeAmountBuilder setPrincipalAmount(NonNegativeMoney principalAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amountRelativeTo"), processor, AmountReference.AmountReferenceBuilder.class, getAmountRelativeTo());
			processRosetta(path.newSubPath("determinationMethod"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getDeterminationMethod());
			processRosetta(path.newSubPath("principalAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPrincipalAmount());
		}
		

		PrincipalExchangeAmount.PrincipalExchangeAmountBuilder prune();
	}

	/*********************** Immutable Implementation of PrincipalExchangeAmount  ***********************/
	class PrincipalExchangeAmountImpl implements PrincipalExchangeAmount {
		private final AmountReference amountRelativeTo;
		private final DeterminationMethod determinationMethod;
		private final NonNegativeMoney principalAmount;
		
		protected PrincipalExchangeAmountImpl(PrincipalExchangeAmount.PrincipalExchangeAmountBuilder builder) {
			this.amountRelativeTo = ofNullable(builder.getAmountRelativeTo()).map(f->f.build()).orElse(null);
			this.determinationMethod = ofNullable(builder.getDeterminationMethod()).map(f->f.build()).orElse(null);
			this.principalAmount = ofNullable(builder.getPrincipalAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amountRelativeTo")
		public AmountReference getAmountRelativeTo() {
			return amountRelativeTo;
		}
		
		@Override
		@RosettaAttribute("determinationMethod")
		public DeterminationMethod getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		@RosettaAttribute("principalAmount")
		public NonNegativeMoney getPrincipalAmount() {
			return principalAmount;
		}
		
		@Override
		public PrincipalExchangeAmount build() {
			return this;
		}
		
		@Override
		public PrincipalExchangeAmount.PrincipalExchangeAmountBuilder toBuilder() {
			PrincipalExchangeAmount.PrincipalExchangeAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PrincipalExchangeAmount.PrincipalExchangeAmountBuilder builder) {
			ofNullable(getAmountRelativeTo()).ifPresent(builder::setAmountRelativeTo);
			ofNullable(getDeterminationMethod()).ifPresent(builder::setDeterminationMethod);
			ofNullable(getPrincipalAmount()).ifPresent(builder::setPrincipalAmount);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalExchangeAmount _that = getType().cast(o);
		
			if (!Objects.equals(amountRelativeTo, _that.getAmountRelativeTo())) return false;
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(principalAmount, _that.getPrincipalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amountRelativeTo != null ? amountRelativeTo.hashCode() : 0);
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.hashCode() : 0);
			_result = 31 * _result + (principalAmount != null ? principalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalExchangeAmount {" +
				"amountRelativeTo=" + this.amountRelativeTo + ", " +
				"determinationMethod=" + this.determinationMethod + ", " +
				"principalAmount=" + this.principalAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of PrincipalExchangeAmount  ***********************/
	class PrincipalExchangeAmountBuilderImpl implements PrincipalExchangeAmount.PrincipalExchangeAmountBuilder {
	
		protected AmountReference.AmountReferenceBuilder amountRelativeTo;
		protected DeterminationMethod.DeterminationMethodBuilder determinationMethod;
		protected NonNegativeMoney.NonNegativeMoneyBuilder principalAmount;
	
		public PrincipalExchangeAmountBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("amountRelativeTo")
		public AmountReference.AmountReferenceBuilder getAmountRelativeTo() {
			return amountRelativeTo;
		}
		
		@Override
		public AmountReference.AmountReferenceBuilder getOrCreateAmountRelativeTo() {
			AmountReference.AmountReferenceBuilder result;
			if (amountRelativeTo!=null) {
				result = amountRelativeTo;
			}
			else {
				result = amountRelativeTo = AmountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("determinationMethod")
		public DeterminationMethod.DeterminationMethodBuilder getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		public DeterminationMethod.DeterminationMethodBuilder getOrCreateDeterminationMethod() {
			DeterminationMethod.DeterminationMethodBuilder result;
			if (determinationMethod!=null) {
				result = determinationMethod;
			}
			else {
				result = determinationMethod = DeterminationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("principalAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getPrincipalAmount() {
			return principalAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePrincipalAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (principalAmount!=null) {
				result = principalAmount;
			}
			else {
				result = principalAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("amountRelativeTo")
		public PrincipalExchangeAmount.PrincipalExchangeAmountBuilder setAmountRelativeTo(AmountReference amountRelativeTo) {
			this.amountRelativeTo = amountRelativeTo==null?null:amountRelativeTo.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("determinationMethod")
		public PrincipalExchangeAmount.PrincipalExchangeAmountBuilder setDeterminationMethod(DeterminationMethod determinationMethod) {
			this.determinationMethod = determinationMethod==null?null:determinationMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("principalAmount")
		public PrincipalExchangeAmount.PrincipalExchangeAmountBuilder setPrincipalAmount(NonNegativeMoney principalAmount) {
			this.principalAmount = principalAmount==null?null:principalAmount.toBuilder();
			return this;
		}
		
		@Override
		public PrincipalExchangeAmount build() {
			return new PrincipalExchangeAmount.PrincipalExchangeAmountImpl(this);
		}
		
		@Override
		public PrincipalExchangeAmount.PrincipalExchangeAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalExchangeAmount.PrincipalExchangeAmountBuilder prune() {
			if (amountRelativeTo!=null && !amountRelativeTo.prune().hasData()) amountRelativeTo = null;
			if (determinationMethod!=null && !determinationMethod.prune().hasData()) determinationMethod = null;
			if (principalAmount!=null && !principalAmount.prune().hasData()) principalAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmountRelativeTo()!=null && getAmountRelativeTo().hasData()) return true;
			if (getDeterminationMethod()!=null && getDeterminationMethod().hasData()) return true;
			if (getPrincipalAmount()!=null && getPrincipalAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalExchangeAmount.PrincipalExchangeAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PrincipalExchangeAmount.PrincipalExchangeAmountBuilder o = (PrincipalExchangeAmount.PrincipalExchangeAmountBuilder) other;
			
			merger.mergeRosetta(getAmountRelativeTo(), o.getAmountRelativeTo(), this::setAmountRelativeTo);
			merger.mergeRosetta(getDeterminationMethod(), o.getDeterminationMethod(), this::setDeterminationMethod);
			merger.mergeRosetta(getPrincipalAmount(), o.getPrincipalAmount(), this::setPrincipalAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalExchangeAmount _that = getType().cast(o);
		
			if (!Objects.equals(amountRelativeTo, _that.getAmountRelativeTo())) return false;
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(principalAmount, _that.getPrincipalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amountRelativeTo != null ? amountRelativeTo.hashCode() : 0);
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.hashCode() : 0);
			_result = 31 * _result + (principalAmount != null ? principalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalExchangeAmountBuilder {" +
				"amountRelativeTo=" + this.amountRelativeTo + ", " +
				"determinationMethod=" + this.determinationMethod + ", " +
				"principalAmount=" + this.principalAmount +
			'}';
		}
	}
}
