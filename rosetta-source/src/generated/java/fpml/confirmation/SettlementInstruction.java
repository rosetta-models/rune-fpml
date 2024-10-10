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
import com.rosetta.util.ListEquals;
import fpml.confirmation.Beneficiary;
import fpml.confirmation.CorrespondentInformation;
import fpml.confirmation.IntermediaryInformation;
import fpml.confirmation.PartyReference;
import fpml.confirmation.SettlementInstruction;
import fpml.confirmation.SettlementInstruction.SettlementInstructionBuilder;
import fpml.confirmation.SettlementInstruction.SettlementInstructionBuilderImpl;
import fpml.confirmation.SettlementInstruction.SettlementInstructionImpl;
import fpml.confirmation.SettlementMethod;
import fpml.confirmation.SplitSettlement;
import fpml.confirmation.meta.SettlementInstructionMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type that models a complete instruction for settling a currency payment, including the settlement method to be used, the correspondent bank, any intermediary banks and the ultimate beneficary.
 * @version ${project.version}
 */
@RosettaDataType(value="SettlementInstruction", builder=SettlementInstruction.SettlementInstructionBuilderImpl.class, version="${project.version}")
public interface SettlementInstruction extends RosettaModelObject {

	SettlementInstructionMeta metaData = new SettlementInstructionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The mechanism by which settlement is to be made. The scheme of domain values will include standard mechanisms such as CLS, Fedwire, Chips ABA, Chips UID, SWIFT, CHAPS and DDA.
	 */
	SettlementMethod getSettlementMethod();
	/**
	 * The information required to identify the correspondent bank that will make delivery of the funds on the paying bank&#39;s behalf in the country where the payment is to be made
	 */
	CorrespondentInformation getCorrespondentInformation();
	/**
	 * Information to identify an intermediary through which payment will be made by the correspondent bank to the ultimate beneficiary of the funds.
	 */
	List<? extends IntermediaryInformation> getIntermediaryInformation();
	/**
	 * The bank that acts for the ultimate beneficiary of the funds in receiving payments.
	 */
	Beneficiary getBeneficiaryBank();
	/**
	 * The ultimate beneficiary of the funds. The beneficiary can be identified either by an account at the beneficiaryBank (qv) or by explicit routingInformation. This element provides for the latter.
	 */
	Beneficiary getBeneficiary();
	/**
	 * Reference to the depository of the settlement.
	 */
	PartyReference getDepositoryPartyReference();
	/**
	 * The set of individual payments that are to be made when a currency payment settling a trade needs to be split between a number of ultimate beneficiaries. Each split payment may need to have its own routing information.
	 */
	List<? extends SplitSettlement> getSplitSettlement();

	/*********************** Build Methods  ***********************/
	SettlementInstruction build();
	
	SettlementInstruction.SettlementInstructionBuilder toBuilder();
	
	static SettlementInstruction.SettlementInstructionBuilder builder() {
		return new SettlementInstruction.SettlementInstructionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementInstruction> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SettlementInstruction> getType() {
		return SettlementInstruction.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("settlementMethod"), processor, SettlementMethod.class, getSettlementMethod());
		processRosetta(path.newSubPath("correspondentInformation"), processor, CorrespondentInformation.class, getCorrespondentInformation());
		processRosetta(path.newSubPath("intermediaryInformation"), processor, IntermediaryInformation.class, getIntermediaryInformation());
		processRosetta(path.newSubPath("beneficiaryBank"), processor, Beneficiary.class, getBeneficiaryBank());
		processRosetta(path.newSubPath("beneficiary"), processor, Beneficiary.class, getBeneficiary());
		processRosetta(path.newSubPath("depositoryPartyReference"), processor, PartyReference.class, getDepositoryPartyReference());
		processRosetta(path.newSubPath("splitSettlement"), processor, SplitSettlement.class, getSplitSettlement());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementInstructionBuilder extends SettlementInstruction, RosettaModelObjectBuilder {
		SettlementMethod.SettlementMethodBuilder getOrCreateSettlementMethod();
		SettlementMethod.SettlementMethodBuilder getSettlementMethod();
		CorrespondentInformation.CorrespondentInformationBuilder getOrCreateCorrespondentInformation();
		CorrespondentInformation.CorrespondentInformationBuilder getCorrespondentInformation();
		IntermediaryInformation.IntermediaryInformationBuilder getOrCreateIntermediaryInformation(int _index);
		List<? extends IntermediaryInformation.IntermediaryInformationBuilder> getIntermediaryInformation();
		Beneficiary.BeneficiaryBuilder getOrCreateBeneficiaryBank();
		Beneficiary.BeneficiaryBuilder getBeneficiaryBank();
		Beneficiary.BeneficiaryBuilder getOrCreateBeneficiary();
		Beneficiary.BeneficiaryBuilder getBeneficiary();
		PartyReference.PartyReferenceBuilder getOrCreateDepositoryPartyReference();
		PartyReference.PartyReferenceBuilder getDepositoryPartyReference();
		SplitSettlement.SplitSettlementBuilder getOrCreateSplitSettlement(int _index);
		List<? extends SplitSettlement.SplitSettlementBuilder> getSplitSettlement();
		SettlementInstruction.SettlementInstructionBuilder setSettlementMethod(SettlementMethod settlementMethod);
		SettlementInstruction.SettlementInstructionBuilder setCorrespondentInformation(CorrespondentInformation correspondentInformation);
		SettlementInstruction.SettlementInstructionBuilder addIntermediaryInformation(IntermediaryInformation intermediaryInformation0);
		SettlementInstruction.SettlementInstructionBuilder addIntermediaryInformation(IntermediaryInformation intermediaryInformation1, int _idx);
		SettlementInstruction.SettlementInstructionBuilder addIntermediaryInformation(List<? extends IntermediaryInformation> intermediaryInformation2);
		SettlementInstruction.SettlementInstructionBuilder setIntermediaryInformation(List<? extends IntermediaryInformation> intermediaryInformation3);
		SettlementInstruction.SettlementInstructionBuilder setBeneficiaryBank(Beneficiary beneficiaryBank);
		SettlementInstruction.SettlementInstructionBuilder setBeneficiary(Beneficiary beneficiary);
		SettlementInstruction.SettlementInstructionBuilder setDepositoryPartyReference(PartyReference depositoryPartyReference);
		SettlementInstruction.SettlementInstructionBuilder addSplitSettlement(SplitSettlement splitSettlement0);
		SettlementInstruction.SettlementInstructionBuilder addSplitSettlement(SplitSettlement splitSettlement1, int _idx);
		SettlementInstruction.SettlementInstructionBuilder addSplitSettlement(List<? extends SplitSettlement> splitSettlement2);
		SettlementInstruction.SettlementInstructionBuilder setSplitSettlement(List<? extends SplitSettlement> splitSettlement3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("settlementMethod"), processor, SettlementMethod.SettlementMethodBuilder.class, getSettlementMethod());
			processRosetta(path.newSubPath("correspondentInformation"), processor, CorrespondentInformation.CorrespondentInformationBuilder.class, getCorrespondentInformation());
			processRosetta(path.newSubPath("intermediaryInformation"), processor, IntermediaryInformation.IntermediaryInformationBuilder.class, getIntermediaryInformation());
			processRosetta(path.newSubPath("beneficiaryBank"), processor, Beneficiary.BeneficiaryBuilder.class, getBeneficiaryBank());
			processRosetta(path.newSubPath("beneficiary"), processor, Beneficiary.BeneficiaryBuilder.class, getBeneficiary());
			processRosetta(path.newSubPath("depositoryPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getDepositoryPartyReference());
			processRosetta(path.newSubPath("splitSettlement"), processor, SplitSettlement.SplitSettlementBuilder.class, getSplitSettlement());
		}
		

		SettlementInstruction.SettlementInstructionBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementInstruction  ***********************/
	class SettlementInstructionImpl implements SettlementInstruction {
		private final SettlementMethod settlementMethod;
		private final CorrespondentInformation correspondentInformation;
		private final List<? extends IntermediaryInformation> intermediaryInformation;
		private final Beneficiary beneficiaryBank;
		private final Beneficiary beneficiary;
		private final PartyReference depositoryPartyReference;
		private final List<? extends SplitSettlement> splitSettlement;
		
		protected SettlementInstructionImpl(SettlementInstruction.SettlementInstructionBuilder builder) {
			this.settlementMethod = ofNullable(builder.getSettlementMethod()).map(f->f.build()).orElse(null);
			this.correspondentInformation = ofNullable(builder.getCorrespondentInformation()).map(f->f.build()).orElse(null);
			this.intermediaryInformation = ofNullable(builder.getIntermediaryInformation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.beneficiaryBank = ofNullable(builder.getBeneficiaryBank()).map(f->f.build()).orElse(null);
			this.beneficiary = ofNullable(builder.getBeneficiary()).map(f->f.build()).orElse(null);
			this.depositoryPartyReference = ofNullable(builder.getDepositoryPartyReference()).map(f->f.build()).orElse(null);
			this.splitSettlement = ofNullable(builder.getSplitSettlement()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementMethod")
		public SettlementMethod getSettlementMethod() {
			return settlementMethod;
		}
		
		@Override
		@RosettaAttribute("correspondentInformation")
		public CorrespondentInformation getCorrespondentInformation() {
			return correspondentInformation;
		}
		
		@Override
		@RosettaAttribute("intermediaryInformation")
		public List<? extends IntermediaryInformation> getIntermediaryInformation() {
			return intermediaryInformation;
		}
		
		@Override
		@RosettaAttribute("beneficiaryBank")
		public Beneficiary getBeneficiaryBank() {
			return beneficiaryBank;
		}
		
		@Override
		@RosettaAttribute("beneficiary")
		public Beneficiary getBeneficiary() {
			return beneficiary;
		}
		
		@Override
		@RosettaAttribute("depositoryPartyReference")
		public PartyReference getDepositoryPartyReference() {
			return depositoryPartyReference;
		}
		
		@Override
		@RosettaAttribute("splitSettlement")
		public List<? extends SplitSettlement> getSplitSettlement() {
			return splitSettlement;
		}
		
		@Override
		public SettlementInstruction build() {
			return this;
		}
		
		@Override
		public SettlementInstruction.SettlementInstructionBuilder toBuilder() {
			SettlementInstruction.SettlementInstructionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementInstruction.SettlementInstructionBuilder builder) {
			ofNullable(getSettlementMethod()).ifPresent(builder::setSettlementMethod);
			ofNullable(getCorrespondentInformation()).ifPresent(builder::setCorrespondentInformation);
			ofNullable(getIntermediaryInformation()).ifPresent(builder::setIntermediaryInformation);
			ofNullable(getBeneficiaryBank()).ifPresent(builder::setBeneficiaryBank);
			ofNullable(getBeneficiary()).ifPresent(builder::setBeneficiary);
			ofNullable(getDepositoryPartyReference()).ifPresent(builder::setDepositoryPartyReference);
			ofNullable(getSplitSettlement()).ifPresent(builder::setSplitSettlement);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementInstruction _that = getType().cast(o);
		
			if (!Objects.equals(settlementMethod, _that.getSettlementMethod())) return false;
			if (!Objects.equals(correspondentInformation, _that.getCorrespondentInformation())) return false;
			if (!ListEquals.listEquals(intermediaryInformation, _that.getIntermediaryInformation())) return false;
			if (!Objects.equals(beneficiaryBank, _that.getBeneficiaryBank())) return false;
			if (!Objects.equals(beneficiary, _that.getBeneficiary())) return false;
			if (!Objects.equals(depositoryPartyReference, _that.getDepositoryPartyReference())) return false;
			if (!ListEquals.listEquals(splitSettlement, _that.getSplitSettlement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementMethod != null ? settlementMethod.hashCode() : 0);
			_result = 31 * _result + (correspondentInformation != null ? correspondentInformation.hashCode() : 0);
			_result = 31 * _result + (intermediaryInformation != null ? intermediaryInformation.hashCode() : 0);
			_result = 31 * _result + (beneficiaryBank != null ? beneficiaryBank.hashCode() : 0);
			_result = 31 * _result + (beneficiary != null ? beneficiary.hashCode() : 0);
			_result = 31 * _result + (depositoryPartyReference != null ? depositoryPartyReference.hashCode() : 0);
			_result = 31 * _result + (splitSettlement != null ? splitSettlement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementInstruction {" +
				"settlementMethod=" + this.settlementMethod + ", " +
				"correspondentInformation=" + this.correspondentInformation + ", " +
				"intermediaryInformation=" + this.intermediaryInformation + ", " +
				"beneficiaryBank=" + this.beneficiaryBank + ", " +
				"beneficiary=" + this.beneficiary + ", " +
				"depositoryPartyReference=" + this.depositoryPartyReference + ", " +
				"splitSettlement=" + this.splitSettlement +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementInstruction  ***********************/
	class SettlementInstructionBuilderImpl implements SettlementInstruction.SettlementInstructionBuilder {
	
		protected SettlementMethod.SettlementMethodBuilder settlementMethod;
		protected CorrespondentInformation.CorrespondentInformationBuilder correspondentInformation;
		protected List<IntermediaryInformation.IntermediaryInformationBuilder> intermediaryInformation = new ArrayList<>();
		protected Beneficiary.BeneficiaryBuilder beneficiaryBank;
		protected Beneficiary.BeneficiaryBuilder beneficiary;
		protected PartyReference.PartyReferenceBuilder depositoryPartyReference;
		protected List<SplitSettlement.SplitSettlementBuilder> splitSettlement = new ArrayList<>();
	
		public SettlementInstructionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlementMethod")
		public SettlementMethod.SettlementMethodBuilder getSettlementMethod() {
			return settlementMethod;
		}
		
		@Override
		public SettlementMethod.SettlementMethodBuilder getOrCreateSettlementMethod() {
			SettlementMethod.SettlementMethodBuilder result;
			if (settlementMethod!=null) {
				result = settlementMethod;
			}
			else {
				result = settlementMethod = SettlementMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("correspondentInformation")
		public CorrespondentInformation.CorrespondentInformationBuilder getCorrespondentInformation() {
			return correspondentInformation;
		}
		
		@Override
		public CorrespondentInformation.CorrespondentInformationBuilder getOrCreateCorrespondentInformation() {
			CorrespondentInformation.CorrespondentInformationBuilder result;
			if (correspondentInformation!=null) {
				result = correspondentInformation;
			}
			else {
				result = correspondentInformation = CorrespondentInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("intermediaryInformation")
		public List<? extends IntermediaryInformation.IntermediaryInformationBuilder> getIntermediaryInformation() {
			return intermediaryInformation;
		}
		
		public IntermediaryInformation.IntermediaryInformationBuilder getOrCreateIntermediaryInformation(int _index) {
		
			if (intermediaryInformation==null) {
				this.intermediaryInformation = new ArrayList<>();
			}
			IntermediaryInformation.IntermediaryInformationBuilder result;
			return getIndex(intermediaryInformation, _index, () -> {
						IntermediaryInformation.IntermediaryInformationBuilder newIntermediaryInformation = IntermediaryInformation.builder();
						return newIntermediaryInformation;
					});
		}
		
		@Override
		@RosettaAttribute("beneficiaryBank")
		public Beneficiary.BeneficiaryBuilder getBeneficiaryBank() {
			return beneficiaryBank;
		}
		
		@Override
		public Beneficiary.BeneficiaryBuilder getOrCreateBeneficiaryBank() {
			Beneficiary.BeneficiaryBuilder result;
			if (beneficiaryBank!=null) {
				result = beneficiaryBank;
			}
			else {
				result = beneficiaryBank = Beneficiary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("beneficiary")
		public Beneficiary.BeneficiaryBuilder getBeneficiary() {
			return beneficiary;
		}
		
		@Override
		public Beneficiary.BeneficiaryBuilder getOrCreateBeneficiary() {
			Beneficiary.BeneficiaryBuilder result;
			if (beneficiary!=null) {
				result = beneficiary;
			}
			else {
				result = beneficiary = Beneficiary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("depositoryPartyReference")
		public PartyReference.PartyReferenceBuilder getDepositoryPartyReference() {
			return depositoryPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateDepositoryPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (depositoryPartyReference!=null) {
				result = depositoryPartyReference;
			}
			else {
				result = depositoryPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("splitSettlement")
		public List<? extends SplitSettlement.SplitSettlementBuilder> getSplitSettlement() {
			return splitSettlement;
		}
		
		public SplitSettlement.SplitSettlementBuilder getOrCreateSplitSettlement(int _index) {
		
			if (splitSettlement==null) {
				this.splitSettlement = new ArrayList<>();
			}
			SplitSettlement.SplitSettlementBuilder result;
			return getIndex(splitSettlement, _index, () -> {
						SplitSettlement.SplitSettlementBuilder newSplitSettlement = SplitSettlement.builder();
						return newSplitSettlement;
					});
		}
		
		@Override
		@RosettaAttribute("settlementMethod")
		public SettlementInstruction.SettlementInstructionBuilder setSettlementMethod(SettlementMethod settlementMethod) {
			this.settlementMethod = settlementMethod==null?null:settlementMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correspondentInformation")
		public SettlementInstruction.SettlementInstructionBuilder setCorrespondentInformation(CorrespondentInformation correspondentInformation) {
			this.correspondentInformation = correspondentInformation==null?null:correspondentInformation.toBuilder();
			return this;
		}
		@Override
		public SettlementInstruction.SettlementInstructionBuilder addIntermediaryInformation(IntermediaryInformation intermediaryInformation) {
			if (intermediaryInformation!=null) this.intermediaryInformation.add(intermediaryInformation.toBuilder());
			return this;
		}
		
		@Override
		public SettlementInstruction.SettlementInstructionBuilder addIntermediaryInformation(IntermediaryInformation intermediaryInformation, int _idx) {
			getIndex(this.intermediaryInformation, _idx, () -> intermediaryInformation.toBuilder());
			return this;
		}
		@Override 
		public SettlementInstruction.SettlementInstructionBuilder addIntermediaryInformation(List<? extends IntermediaryInformation> intermediaryInformations) {
			if (intermediaryInformations != null) {
				for (IntermediaryInformation toAdd : intermediaryInformations) {
					this.intermediaryInformation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("intermediaryInformation")
		public SettlementInstruction.SettlementInstructionBuilder setIntermediaryInformation(List<? extends IntermediaryInformation> intermediaryInformations) {
			if (intermediaryInformations == null)  {
				this.intermediaryInformation = new ArrayList<>();
			}
			else {
				this.intermediaryInformation = intermediaryInformations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("beneficiaryBank")
		public SettlementInstruction.SettlementInstructionBuilder setBeneficiaryBank(Beneficiary beneficiaryBank) {
			this.beneficiaryBank = beneficiaryBank==null?null:beneficiaryBank.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("beneficiary")
		public SettlementInstruction.SettlementInstructionBuilder setBeneficiary(Beneficiary beneficiary) {
			this.beneficiary = beneficiary==null?null:beneficiary.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("depositoryPartyReference")
		public SettlementInstruction.SettlementInstructionBuilder setDepositoryPartyReference(PartyReference depositoryPartyReference) {
			this.depositoryPartyReference = depositoryPartyReference==null?null:depositoryPartyReference.toBuilder();
			return this;
		}
		@Override
		public SettlementInstruction.SettlementInstructionBuilder addSplitSettlement(SplitSettlement splitSettlement) {
			if (splitSettlement!=null) this.splitSettlement.add(splitSettlement.toBuilder());
			return this;
		}
		
		@Override
		public SettlementInstruction.SettlementInstructionBuilder addSplitSettlement(SplitSettlement splitSettlement, int _idx) {
			getIndex(this.splitSettlement, _idx, () -> splitSettlement.toBuilder());
			return this;
		}
		@Override 
		public SettlementInstruction.SettlementInstructionBuilder addSplitSettlement(List<? extends SplitSettlement> splitSettlements) {
			if (splitSettlements != null) {
				for (SplitSettlement toAdd : splitSettlements) {
					this.splitSettlement.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("splitSettlement")
		public SettlementInstruction.SettlementInstructionBuilder setSplitSettlement(List<? extends SplitSettlement> splitSettlements) {
			if (splitSettlements == null)  {
				this.splitSettlement = new ArrayList<>();
			}
			else {
				this.splitSettlement = splitSettlements.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public SettlementInstruction build() {
			return new SettlementInstruction.SettlementInstructionImpl(this);
		}
		
		@Override
		public SettlementInstruction.SettlementInstructionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementInstruction.SettlementInstructionBuilder prune() {
			if (settlementMethod!=null && !settlementMethod.prune().hasData()) settlementMethod = null;
			if (correspondentInformation!=null && !correspondentInformation.prune().hasData()) correspondentInformation = null;
			intermediaryInformation = intermediaryInformation.stream().filter(b->b!=null).<IntermediaryInformation.IntermediaryInformationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (beneficiaryBank!=null && !beneficiaryBank.prune().hasData()) beneficiaryBank = null;
			if (beneficiary!=null && !beneficiary.prune().hasData()) beneficiary = null;
			if (depositoryPartyReference!=null && !depositoryPartyReference.prune().hasData()) depositoryPartyReference = null;
			splitSettlement = splitSettlement.stream().filter(b->b!=null).<SplitSettlement.SplitSettlementBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementMethod()!=null && getSettlementMethod().hasData()) return true;
			if (getCorrespondentInformation()!=null && getCorrespondentInformation().hasData()) return true;
			if (getIntermediaryInformation()!=null && getIntermediaryInformation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBeneficiaryBank()!=null && getBeneficiaryBank().hasData()) return true;
			if (getBeneficiary()!=null && getBeneficiary().hasData()) return true;
			if (getDepositoryPartyReference()!=null && getDepositoryPartyReference().hasData()) return true;
			if (getSplitSettlement()!=null && getSplitSettlement().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementInstruction.SettlementInstructionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementInstruction.SettlementInstructionBuilder o = (SettlementInstruction.SettlementInstructionBuilder) other;
			
			merger.mergeRosetta(getSettlementMethod(), o.getSettlementMethod(), this::setSettlementMethod);
			merger.mergeRosetta(getCorrespondentInformation(), o.getCorrespondentInformation(), this::setCorrespondentInformation);
			merger.mergeRosetta(getIntermediaryInformation(), o.getIntermediaryInformation(), this::getOrCreateIntermediaryInformation);
			merger.mergeRosetta(getBeneficiaryBank(), o.getBeneficiaryBank(), this::setBeneficiaryBank);
			merger.mergeRosetta(getBeneficiary(), o.getBeneficiary(), this::setBeneficiary);
			merger.mergeRosetta(getDepositoryPartyReference(), o.getDepositoryPartyReference(), this::setDepositoryPartyReference);
			merger.mergeRosetta(getSplitSettlement(), o.getSplitSettlement(), this::getOrCreateSplitSettlement);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementInstruction _that = getType().cast(o);
		
			if (!Objects.equals(settlementMethod, _that.getSettlementMethod())) return false;
			if (!Objects.equals(correspondentInformation, _that.getCorrespondentInformation())) return false;
			if (!ListEquals.listEquals(intermediaryInformation, _that.getIntermediaryInformation())) return false;
			if (!Objects.equals(beneficiaryBank, _that.getBeneficiaryBank())) return false;
			if (!Objects.equals(beneficiary, _that.getBeneficiary())) return false;
			if (!Objects.equals(depositoryPartyReference, _that.getDepositoryPartyReference())) return false;
			if (!ListEquals.listEquals(splitSettlement, _that.getSplitSettlement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementMethod != null ? settlementMethod.hashCode() : 0);
			_result = 31 * _result + (correspondentInformation != null ? correspondentInformation.hashCode() : 0);
			_result = 31 * _result + (intermediaryInformation != null ? intermediaryInformation.hashCode() : 0);
			_result = 31 * _result + (beneficiaryBank != null ? beneficiaryBank.hashCode() : 0);
			_result = 31 * _result + (beneficiary != null ? beneficiary.hashCode() : 0);
			_result = 31 * _result + (depositoryPartyReference != null ? depositoryPartyReference.hashCode() : 0);
			_result = 31 * _result + (splitSettlement != null ? splitSettlement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementInstructionBuilder {" +
				"settlementMethod=" + this.settlementMethod + ", " +
				"correspondentInformation=" + this.correspondentInformation + ", " +
				"intermediaryInformation=" + this.intermediaryInformation + ", " +
				"beneficiaryBank=" + this.beneficiaryBank + ", " +
				"beneficiary=" + this.beneficiary + ", " +
				"depositoryPartyReference=" + this.depositoryPartyReference + ", " +
				"splitSettlement=" + this.splitSettlement +
			'}';
		}
	}
}
