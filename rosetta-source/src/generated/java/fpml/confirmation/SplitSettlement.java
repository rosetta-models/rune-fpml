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
import fpml.confirmation.Money;
import fpml.confirmation.Routing;
import fpml.confirmation.SplitSettlement;
import fpml.confirmation.SplitSettlement.SplitSettlementBuilder;
import fpml.confirmation.SplitSettlement.SplitSettlementBuilderImpl;
import fpml.confirmation.SplitSettlement.SplitSettlementImpl;
import fpml.confirmation.meta.SplitSettlementMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that supports the division of a gross settlement amount into a number of split settlements, each requiring its own settlement instruction.
 * @version ${project.version}
 */
@RosettaDataType(value="SplitSettlement", builder=SplitSettlement.SplitSettlementBuilderImpl.class, version="${project.version}")
public interface SplitSettlement extends RosettaModelObject {

	SplitSettlementMeta metaData = new SplitSettlementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * One of the monetary amounts in a split settlement payment.
	 */
	Money getSplitSettlementAmount();
	/**
	 * The bank that acts for the ultimate beneficiary of the funds in receiving payments.
	 */
	Routing getBeneficiaryBank();
	/**
	 * The ultimate beneficiary of the funds. The beneficiary can be identified either by an account at the beneficiaryBank (qv) or by explicit routingInformation. This element provides for the latter.
	 */
	Routing getBeneficiary();

	/*********************** Build Methods  ***********************/
	SplitSettlement build();
	
	SplitSettlement.SplitSettlementBuilder toBuilder();
	
	static SplitSettlement.SplitSettlementBuilder builder() {
		return new SplitSettlement.SplitSettlementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SplitSettlement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SplitSettlement> getType() {
		return SplitSettlement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("splitSettlementAmount"), processor, Money.class, getSplitSettlementAmount());
		processRosetta(path.newSubPath("beneficiaryBank"), processor, Routing.class, getBeneficiaryBank());
		processRosetta(path.newSubPath("beneficiary"), processor, Routing.class, getBeneficiary());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SplitSettlementBuilder extends SplitSettlement, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateSplitSettlementAmount();
		Money.MoneyBuilder getSplitSettlementAmount();
		Routing.RoutingBuilder getOrCreateBeneficiaryBank();
		Routing.RoutingBuilder getBeneficiaryBank();
		Routing.RoutingBuilder getOrCreateBeneficiary();
		Routing.RoutingBuilder getBeneficiary();
		SplitSettlement.SplitSettlementBuilder setSplitSettlementAmount(Money splitSettlementAmount);
		SplitSettlement.SplitSettlementBuilder setBeneficiaryBank(Routing beneficiaryBank);
		SplitSettlement.SplitSettlementBuilder setBeneficiary(Routing beneficiary);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("splitSettlementAmount"), processor, Money.MoneyBuilder.class, getSplitSettlementAmount());
			processRosetta(path.newSubPath("beneficiaryBank"), processor, Routing.RoutingBuilder.class, getBeneficiaryBank());
			processRosetta(path.newSubPath("beneficiary"), processor, Routing.RoutingBuilder.class, getBeneficiary());
		}
		

		SplitSettlement.SplitSettlementBuilder prune();
	}

	/*********************** Immutable Implementation of SplitSettlement  ***********************/
	class SplitSettlementImpl implements SplitSettlement {
		private final Money splitSettlementAmount;
		private final Routing beneficiaryBank;
		private final Routing beneficiary;
		
		protected SplitSettlementImpl(SplitSettlement.SplitSettlementBuilder builder) {
			this.splitSettlementAmount = ofNullable(builder.getSplitSettlementAmount()).map(f->f.build()).orElse(null);
			this.beneficiaryBank = ofNullable(builder.getBeneficiaryBank()).map(f->f.build()).orElse(null);
			this.beneficiary = ofNullable(builder.getBeneficiary()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("splitSettlementAmount")
		public Money getSplitSettlementAmount() {
			return splitSettlementAmount;
		}
		
		@Override
		@RosettaAttribute("beneficiaryBank")
		public Routing getBeneficiaryBank() {
			return beneficiaryBank;
		}
		
		@Override
		@RosettaAttribute("beneficiary")
		public Routing getBeneficiary() {
			return beneficiary;
		}
		
		@Override
		public SplitSettlement build() {
			return this;
		}
		
		@Override
		public SplitSettlement.SplitSettlementBuilder toBuilder() {
			SplitSettlement.SplitSettlementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SplitSettlement.SplitSettlementBuilder builder) {
			ofNullable(getSplitSettlementAmount()).ifPresent(builder::setSplitSettlementAmount);
			ofNullable(getBeneficiaryBank()).ifPresent(builder::setBeneficiaryBank);
			ofNullable(getBeneficiary()).ifPresent(builder::setBeneficiary);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SplitSettlement _that = getType().cast(o);
		
			if (!Objects.equals(splitSettlementAmount, _that.getSplitSettlementAmount())) return false;
			if (!Objects.equals(beneficiaryBank, _that.getBeneficiaryBank())) return false;
			if (!Objects.equals(beneficiary, _that.getBeneficiary())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (splitSettlementAmount != null ? splitSettlementAmount.hashCode() : 0);
			_result = 31 * _result + (beneficiaryBank != null ? beneficiaryBank.hashCode() : 0);
			_result = 31 * _result + (beneficiary != null ? beneficiary.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SplitSettlement {" +
				"splitSettlementAmount=" + this.splitSettlementAmount + ", " +
				"beneficiaryBank=" + this.beneficiaryBank + ", " +
				"beneficiary=" + this.beneficiary +
			'}';
		}
	}

	/*********************** Builder Implementation of SplitSettlement  ***********************/
	class SplitSettlementBuilderImpl implements SplitSettlement.SplitSettlementBuilder {
	
		protected Money.MoneyBuilder splitSettlementAmount;
		protected Routing.RoutingBuilder beneficiaryBank;
		protected Routing.RoutingBuilder beneficiary;
	
		public SplitSettlementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("splitSettlementAmount")
		public Money.MoneyBuilder getSplitSettlementAmount() {
			return splitSettlementAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateSplitSettlementAmount() {
			Money.MoneyBuilder result;
			if (splitSettlementAmount!=null) {
				result = splitSettlementAmount;
			}
			else {
				result = splitSettlementAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("beneficiaryBank")
		public Routing.RoutingBuilder getBeneficiaryBank() {
			return beneficiaryBank;
		}
		
		@Override
		public Routing.RoutingBuilder getOrCreateBeneficiaryBank() {
			Routing.RoutingBuilder result;
			if (beneficiaryBank!=null) {
				result = beneficiaryBank;
			}
			else {
				result = beneficiaryBank = Routing.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("beneficiary")
		public Routing.RoutingBuilder getBeneficiary() {
			return beneficiary;
		}
		
		@Override
		public Routing.RoutingBuilder getOrCreateBeneficiary() {
			Routing.RoutingBuilder result;
			if (beneficiary!=null) {
				result = beneficiary;
			}
			else {
				result = beneficiary = Routing.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("splitSettlementAmount")
		public SplitSettlement.SplitSettlementBuilder setSplitSettlementAmount(Money splitSettlementAmount) {
			this.splitSettlementAmount = splitSettlementAmount==null?null:splitSettlementAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("beneficiaryBank")
		public SplitSettlement.SplitSettlementBuilder setBeneficiaryBank(Routing beneficiaryBank) {
			this.beneficiaryBank = beneficiaryBank==null?null:beneficiaryBank.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("beneficiary")
		public SplitSettlement.SplitSettlementBuilder setBeneficiary(Routing beneficiary) {
			this.beneficiary = beneficiary==null?null:beneficiary.toBuilder();
			return this;
		}
		
		@Override
		public SplitSettlement build() {
			return new SplitSettlement.SplitSettlementImpl(this);
		}
		
		@Override
		public SplitSettlement.SplitSettlementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SplitSettlement.SplitSettlementBuilder prune() {
			if (splitSettlementAmount!=null && !splitSettlementAmount.prune().hasData()) splitSettlementAmount = null;
			if (beneficiaryBank!=null && !beneficiaryBank.prune().hasData()) beneficiaryBank = null;
			if (beneficiary!=null && !beneficiary.prune().hasData()) beneficiary = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSplitSettlementAmount()!=null && getSplitSettlementAmount().hasData()) return true;
			if (getBeneficiaryBank()!=null && getBeneficiaryBank().hasData()) return true;
			if (getBeneficiary()!=null && getBeneficiary().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SplitSettlement.SplitSettlementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SplitSettlement.SplitSettlementBuilder o = (SplitSettlement.SplitSettlementBuilder) other;
			
			merger.mergeRosetta(getSplitSettlementAmount(), o.getSplitSettlementAmount(), this::setSplitSettlementAmount);
			merger.mergeRosetta(getBeneficiaryBank(), o.getBeneficiaryBank(), this::setBeneficiaryBank);
			merger.mergeRosetta(getBeneficiary(), o.getBeneficiary(), this::setBeneficiary);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SplitSettlement _that = getType().cast(o);
		
			if (!Objects.equals(splitSettlementAmount, _that.getSplitSettlementAmount())) return false;
			if (!Objects.equals(beneficiaryBank, _that.getBeneficiaryBank())) return false;
			if (!Objects.equals(beneficiary, _that.getBeneficiary())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (splitSettlementAmount != null ? splitSettlementAmount.hashCode() : 0);
			_result = 31 * _result + (beneficiaryBank != null ? beneficiaryBank.hashCode() : 0);
			_result = 31 * _result + (beneficiary != null ? beneficiary.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SplitSettlementBuilder {" +
				"splitSettlementAmount=" + this.splitSettlementAmount + ", " +
				"beneficiaryBank=" + this.beneficiaryBank + ", " +
				"beneficiary=" + this.beneficiary +
			'}';
		}
	}
}
