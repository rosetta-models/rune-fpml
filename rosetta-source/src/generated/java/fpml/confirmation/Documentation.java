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
import fpml.confirmation.BrokerConfirmation;
import fpml.confirmation.ContractualDefinitions;
import fpml.confirmation.ContractualMatrix;
import fpml.confirmation.ContractualTermsSupplement;
import fpml.confirmation.CreditSupportAgreement;
import fpml.confirmation.Documentation;
import fpml.confirmation.Documentation.DocumentationBuilder;
import fpml.confirmation.Documentation.DocumentationBuilderImpl;
import fpml.confirmation.Documentation.DocumentationImpl;
import fpml.confirmation.MasterAgreement;
import fpml.confirmation.MasterConfirmation;
import fpml.confirmation.OtherAgreement;
import fpml.confirmation.Resource;
import fpml.confirmation.meta.DocumentationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An entity for defining the definitions that govern the document and should include the year and type of definitions referenced, along with any relevant documentation (such as master agreement) and the date it was signed.
 * @version ${project.version}
 */
@RosettaDataType(value="Documentation", builder=Documentation.DocumentationBuilderImpl.class, version="${project.version}")
public interface Documentation extends RosettaModelObject {

	DocumentationMeta metaData = new DocumentationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The agreement executed between the parties and intended to govern all OTC derivatives transactions between those parties.
	 */
	MasterAgreement getMasterAgreement();
	/**
	 * The agreement executed between the parties and intended to govern all OTC derivatives transactions between those parties.
	 */
	MasterConfirmation getMasterConfirmation();
	/**
	 * Specifies the deails for a broker confirm.
	 */
	BrokerConfirmation getBrokerConfirmation();
	/**
	 * The definitions such as those published by ISDA that will define the terms of the trade.
	 */
	List<? extends ContractualDefinitions> getContractualDefinitions();
	/**
	 * A contractual supplement (such as those published by ISDA) that will apply to the trade.
	 */
	List<? extends ContractualTermsSupplement> getContractualTermsSupplement();
	/**
	 * A reference to a contractual matrix of elected terms/values (such as those published by ISDA) that shall be deemed to apply to the trade. The applicable matrix is identified by reference to a name and optionally a publication date. Depending on the structure of the matrix, an additional term (specified in the matrixTerm element) may be required to further identify a subset of applicable terms/values within the matrix.
	 */
	List<? extends ContractualMatrix> getContractualMatrix();
	/**
	 * The agreement executed between the parties and intended to govern collateral arrangement for all OTC derivatives transactions between those parties.
	 */
	CreditSupportAgreement getCreditSupportAgreement();
	/**
	 * Any other agreement executed between the parties.
	 */
	List<? extends OtherAgreement> getOtherAgreement();
	/**
	 * A human readable document related to this transaction, for example a confirmation.
	 */
	List<? extends Resource> getAttachment();

	/*********************** Build Methods  ***********************/
	Documentation build();
	
	Documentation.DocumentationBuilder toBuilder();
	
	static Documentation.DocumentationBuilder builder() {
		return new Documentation.DocumentationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Documentation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Documentation> getType() {
		return Documentation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("masterAgreement"), processor, MasterAgreement.class, getMasterAgreement());
		processRosetta(path.newSubPath("masterConfirmation"), processor, MasterConfirmation.class, getMasterConfirmation());
		processRosetta(path.newSubPath("brokerConfirmation"), processor, BrokerConfirmation.class, getBrokerConfirmation());
		processRosetta(path.newSubPath("contractualDefinitions"), processor, ContractualDefinitions.class, getContractualDefinitions());
		processRosetta(path.newSubPath("contractualTermsSupplement"), processor, ContractualTermsSupplement.class, getContractualTermsSupplement());
		processRosetta(path.newSubPath("contractualMatrix"), processor, ContractualMatrix.class, getContractualMatrix());
		processRosetta(path.newSubPath("creditSupportAgreement"), processor, CreditSupportAgreement.class, getCreditSupportAgreement());
		processRosetta(path.newSubPath("otherAgreement"), processor, OtherAgreement.class, getOtherAgreement());
		processRosetta(path.newSubPath("attachment"), processor, Resource.class, getAttachment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DocumentationBuilder extends Documentation, RosettaModelObjectBuilder {
		MasterAgreement.MasterAgreementBuilder getOrCreateMasterAgreement();
		MasterAgreement.MasterAgreementBuilder getMasterAgreement();
		MasterConfirmation.MasterConfirmationBuilder getOrCreateMasterConfirmation();
		MasterConfirmation.MasterConfirmationBuilder getMasterConfirmation();
		BrokerConfirmation.BrokerConfirmationBuilder getOrCreateBrokerConfirmation();
		BrokerConfirmation.BrokerConfirmationBuilder getBrokerConfirmation();
		ContractualDefinitions.ContractualDefinitionsBuilder getOrCreateContractualDefinitions(int _index);
		List<? extends ContractualDefinitions.ContractualDefinitionsBuilder> getContractualDefinitions();
		ContractualTermsSupplement.ContractualTermsSupplementBuilder getOrCreateContractualTermsSupplement(int _index);
		List<? extends ContractualTermsSupplement.ContractualTermsSupplementBuilder> getContractualTermsSupplement();
		ContractualMatrix.ContractualMatrixBuilder getOrCreateContractualMatrix(int _index);
		List<? extends ContractualMatrix.ContractualMatrixBuilder> getContractualMatrix();
		CreditSupportAgreement.CreditSupportAgreementBuilder getOrCreateCreditSupportAgreement();
		CreditSupportAgreement.CreditSupportAgreementBuilder getCreditSupportAgreement();
		OtherAgreement.OtherAgreementBuilder getOrCreateOtherAgreement(int _index);
		List<? extends OtherAgreement.OtherAgreementBuilder> getOtherAgreement();
		Resource.ResourceBuilder getOrCreateAttachment(int _index);
		List<? extends Resource.ResourceBuilder> getAttachment();
		Documentation.DocumentationBuilder setMasterAgreement(MasterAgreement masterAgreement);
		Documentation.DocumentationBuilder setMasterConfirmation(MasterConfirmation masterConfirmation);
		Documentation.DocumentationBuilder setBrokerConfirmation(BrokerConfirmation brokerConfirmation);
		Documentation.DocumentationBuilder addContractualDefinitions(ContractualDefinitions contractualDefinitions0);
		Documentation.DocumentationBuilder addContractualDefinitions(ContractualDefinitions contractualDefinitions1, int _idx);
		Documentation.DocumentationBuilder addContractualDefinitions(List<? extends ContractualDefinitions> contractualDefinitions2);
		Documentation.DocumentationBuilder setContractualDefinitions(List<? extends ContractualDefinitions> contractualDefinitions3);
		Documentation.DocumentationBuilder addContractualTermsSupplement(ContractualTermsSupplement contractualTermsSupplement0);
		Documentation.DocumentationBuilder addContractualTermsSupplement(ContractualTermsSupplement contractualTermsSupplement1, int _idx);
		Documentation.DocumentationBuilder addContractualTermsSupplement(List<? extends ContractualTermsSupplement> contractualTermsSupplement2);
		Documentation.DocumentationBuilder setContractualTermsSupplement(List<? extends ContractualTermsSupplement> contractualTermsSupplement3);
		Documentation.DocumentationBuilder addContractualMatrix(ContractualMatrix contractualMatrix0);
		Documentation.DocumentationBuilder addContractualMatrix(ContractualMatrix contractualMatrix1, int _idx);
		Documentation.DocumentationBuilder addContractualMatrix(List<? extends ContractualMatrix> contractualMatrix2);
		Documentation.DocumentationBuilder setContractualMatrix(List<? extends ContractualMatrix> contractualMatrix3);
		Documentation.DocumentationBuilder setCreditSupportAgreement(CreditSupportAgreement creditSupportAgreement);
		Documentation.DocumentationBuilder addOtherAgreement(OtherAgreement otherAgreement0);
		Documentation.DocumentationBuilder addOtherAgreement(OtherAgreement otherAgreement1, int _idx);
		Documentation.DocumentationBuilder addOtherAgreement(List<? extends OtherAgreement> otherAgreement2);
		Documentation.DocumentationBuilder setOtherAgreement(List<? extends OtherAgreement> otherAgreement3);
		Documentation.DocumentationBuilder addAttachment(Resource attachment0);
		Documentation.DocumentationBuilder addAttachment(Resource attachment1, int _idx);
		Documentation.DocumentationBuilder addAttachment(List<? extends Resource> attachment2);
		Documentation.DocumentationBuilder setAttachment(List<? extends Resource> attachment3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("masterAgreement"), processor, MasterAgreement.MasterAgreementBuilder.class, getMasterAgreement());
			processRosetta(path.newSubPath("masterConfirmation"), processor, MasterConfirmation.MasterConfirmationBuilder.class, getMasterConfirmation());
			processRosetta(path.newSubPath("brokerConfirmation"), processor, BrokerConfirmation.BrokerConfirmationBuilder.class, getBrokerConfirmation());
			processRosetta(path.newSubPath("contractualDefinitions"), processor, ContractualDefinitions.ContractualDefinitionsBuilder.class, getContractualDefinitions());
			processRosetta(path.newSubPath("contractualTermsSupplement"), processor, ContractualTermsSupplement.ContractualTermsSupplementBuilder.class, getContractualTermsSupplement());
			processRosetta(path.newSubPath("contractualMatrix"), processor, ContractualMatrix.ContractualMatrixBuilder.class, getContractualMatrix());
			processRosetta(path.newSubPath("creditSupportAgreement"), processor, CreditSupportAgreement.CreditSupportAgreementBuilder.class, getCreditSupportAgreement());
			processRosetta(path.newSubPath("otherAgreement"), processor, OtherAgreement.OtherAgreementBuilder.class, getOtherAgreement());
			processRosetta(path.newSubPath("attachment"), processor, Resource.ResourceBuilder.class, getAttachment());
		}
		

		Documentation.DocumentationBuilder prune();
	}

	/*********************** Immutable Implementation of Documentation  ***********************/
	class DocumentationImpl implements Documentation {
		private final MasterAgreement masterAgreement;
		private final MasterConfirmation masterConfirmation;
		private final BrokerConfirmation brokerConfirmation;
		private final List<? extends ContractualDefinitions> contractualDefinitions;
		private final List<? extends ContractualTermsSupplement> contractualTermsSupplement;
		private final List<? extends ContractualMatrix> contractualMatrix;
		private final CreditSupportAgreement creditSupportAgreement;
		private final List<? extends OtherAgreement> otherAgreement;
		private final List<? extends Resource> attachment;
		
		protected DocumentationImpl(Documentation.DocumentationBuilder builder) {
			this.masterAgreement = ofNullable(builder.getMasterAgreement()).map(f->f.build()).orElse(null);
			this.masterConfirmation = ofNullable(builder.getMasterConfirmation()).map(f->f.build()).orElse(null);
			this.brokerConfirmation = ofNullable(builder.getBrokerConfirmation()).map(f->f.build()).orElse(null);
			this.contractualDefinitions = ofNullable(builder.getContractualDefinitions()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.contractualTermsSupplement = ofNullable(builder.getContractualTermsSupplement()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.contractualMatrix = ofNullable(builder.getContractualMatrix()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.creditSupportAgreement = ofNullable(builder.getCreditSupportAgreement()).map(f->f.build()).orElse(null);
			this.otherAgreement = ofNullable(builder.getOtherAgreement()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.attachment = ofNullable(builder.getAttachment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("masterAgreement")
		public MasterAgreement getMasterAgreement() {
			return masterAgreement;
		}
		
		@Override
		@RosettaAttribute("masterConfirmation")
		public MasterConfirmation getMasterConfirmation() {
			return masterConfirmation;
		}
		
		@Override
		@RosettaAttribute("brokerConfirmation")
		public BrokerConfirmation getBrokerConfirmation() {
			return brokerConfirmation;
		}
		
		@Override
		@RosettaAttribute("contractualDefinitions")
		public List<? extends ContractualDefinitions> getContractualDefinitions() {
			return contractualDefinitions;
		}
		
		@Override
		@RosettaAttribute("contractualTermsSupplement")
		public List<? extends ContractualTermsSupplement> getContractualTermsSupplement() {
			return contractualTermsSupplement;
		}
		
		@Override
		@RosettaAttribute("contractualMatrix")
		public List<? extends ContractualMatrix> getContractualMatrix() {
			return contractualMatrix;
		}
		
		@Override
		@RosettaAttribute("creditSupportAgreement")
		public CreditSupportAgreement getCreditSupportAgreement() {
			return creditSupportAgreement;
		}
		
		@Override
		@RosettaAttribute("otherAgreement")
		public List<? extends OtherAgreement> getOtherAgreement() {
			return otherAgreement;
		}
		
		@Override
		@RosettaAttribute("attachment")
		public List<? extends Resource> getAttachment() {
			return attachment;
		}
		
		@Override
		public Documentation build() {
			return this;
		}
		
		@Override
		public Documentation.DocumentationBuilder toBuilder() {
			Documentation.DocumentationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Documentation.DocumentationBuilder builder) {
			ofNullable(getMasterAgreement()).ifPresent(builder::setMasterAgreement);
			ofNullable(getMasterConfirmation()).ifPresent(builder::setMasterConfirmation);
			ofNullable(getBrokerConfirmation()).ifPresent(builder::setBrokerConfirmation);
			ofNullable(getContractualDefinitions()).ifPresent(builder::setContractualDefinitions);
			ofNullable(getContractualTermsSupplement()).ifPresent(builder::setContractualTermsSupplement);
			ofNullable(getContractualMatrix()).ifPresent(builder::setContractualMatrix);
			ofNullable(getCreditSupportAgreement()).ifPresent(builder::setCreditSupportAgreement);
			ofNullable(getOtherAgreement()).ifPresent(builder::setOtherAgreement);
			ofNullable(getAttachment()).ifPresent(builder::setAttachment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Documentation _that = getType().cast(o);
		
			if (!Objects.equals(masterAgreement, _that.getMasterAgreement())) return false;
			if (!Objects.equals(masterConfirmation, _that.getMasterConfirmation())) return false;
			if (!Objects.equals(brokerConfirmation, _that.getBrokerConfirmation())) return false;
			if (!ListEquals.listEquals(contractualDefinitions, _that.getContractualDefinitions())) return false;
			if (!ListEquals.listEquals(contractualTermsSupplement, _that.getContractualTermsSupplement())) return false;
			if (!ListEquals.listEquals(contractualMatrix, _that.getContractualMatrix())) return false;
			if (!Objects.equals(creditSupportAgreement, _that.getCreditSupportAgreement())) return false;
			if (!ListEquals.listEquals(otherAgreement, _that.getOtherAgreement())) return false;
			if (!ListEquals.listEquals(attachment, _that.getAttachment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (masterAgreement != null ? masterAgreement.hashCode() : 0);
			_result = 31 * _result + (masterConfirmation != null ? masterConfirmation.hashCode() : 0);
			_result = 31 * _result + (brokerConfirmation != null ? brokerConfirmation.hashCode() : 0);
			_result = 31 * _result + (contractualDefinitions != null ? contractualDefinitions.hashCode() : 0);
			_result = 31 * _result + (contractualTermsSupplement != null ? contractualTermsSupplement.hashCode() : 0);
			_result = 31 * _result + (contractualMatrix != null ? contractualMatrix.hashCode() : 0);
			_result = 31 * _result + (creditSupportAgreement != null ? creditSupportAgreement.hashCode() : 0);
			_result = 31 * _result + (otherAgreement != null ? otherAgreement.hashCode() : 0);
			_result = 31 * _result + (attachment != null ? attachment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Documentation {" +
				"masterAgreement=" + this.masterAgreement + ", " +
				"masterConfirmation=" + this.masterConfirmation + ", " +
				"brokerConfirmation=" + this.brokerConfirmation + ", " +
				"contractualDefinitions=" + this.contractualDefinitions + ", " +
				"contractualTermsSupplement=" + this.contractualTermsSupplement + ", " +
				"contractualMatrix=" + this.contractualMatrix + ", " +
				"creditSupportAgreement=" + this.creditSupportAgreement + ", " +
				"otherAgreement=" + this.otherAgreement + ", " +
				"attachment=" + this.attachment +
			'}';
		}
	}

	/*********************** Builder Implementation of Documentation  ***********************/
	class DocumentationBuilderImpl implements Documentation.DocumentationBuilder {
	
		protected MasterAgreement.MasterAgreementBuilder masterAgreement;
		protected MasterConfirmation.MasterConfirmationBuilder masterConfirmation;
		protected BrokerConfirmation.BrokerConfirmationBuilder brokerConfirmation;
		protected List<ContractualDefinitions.ContractualDefinitionsBuilder> contractualDefinitions = new ArrayList<>();
		protected List<ContractualTermsSupplement.ContractualTermsSupplementBuilder> contractualTermsSupplement = new ArrayList<>();
		protected List<ContractualMatrix.ContractualMatrixBuilder> contractualMatrix = new ArrayList<>();
		protected CreditSupportAgreement.CreditSupportAgreementBuilder creditSupportAgreement;
		protected List<OtherAgreement.OtherAgreementBuilder> otherAgreement = new ArrayList<>();
		protected List<Resource.ResourceBuilder> attachment = new ArrayList<>();
	
		public DocumentationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("masterAgreement")
		public MasterAgreement.MasterAgreementBuilder getMasterAgreement() {
			return masterAgreement;
		}
		
		@Override
		public MasterAgreement.MasterAgreementBuilder getOrCreateMasterAgreement() {
			MasterAgreement.MasterAgreementBuilder result;
			if (masterAgreement!=null) {
				result = masterAgreement;
			}
			else {
				result = masterAgreement = MasterAgreement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("masterConfirmation")
		public MasterConfirmation.MasterConfirmationBuilder getMasterConfirmation() {
			return masterConfirmation;
		}
		
		@Override
		public MasterConfirmation.MasterConfirmationBuilder getOrCreateMasterConfirmation() {
			MasterConfirmation.MasterConfirmationBuilder result;
			if (masterConfirmation!=null) {
				result = masterConfirmation;
			}
			else {
				result = masterConfirmation = MasterConfirmation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("brokerConfirmation")
		public BrokerConfirmation.BrokerConfirmationBuilder getBrokerConfirmation() {
			return brokerConfirmation;
		}
		
		@Override
		public BrokerConfirmation.BrokerConfirmationBuilder getOrCreateBrokerConfirmation() {
			BrokerConfirmation.BrokerConfirmationBuilder result;
			if (brokerConfirmation!=null) {
				result = brokerConfirmation;
			}
			else {
				result = brokerConfirmation = BrokerConfirmation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("contractualDefinitions")
		public List<? extends ContractualDefinitions.ContractualDefinitionsBuilder> getContractualDefinitions() {
			return contractualDefinitions;
		}
		
		public ContractualDefinitions.ContractualDefinitionsBuilder getOrCreateContractualDefinitions(int _index) {
		
			if (contractualDefinitions==null) {
				this.contractualDefinitions = new ArrayList<>();
			}
			ContractualDefinitions.ContractualDefinitionsBuilder result;
			return getIndex(contractualDefinitions, _index, () -> {
						ContractualDefinitions.ContractualDefinitionsBuilder newContractualDefinitions = ContractualDefinitions.builder();
						return newContractualDefinitions;
					});
		}
		
		@Override
		@RosettaAttribute("contractualTermsSupplement")
		public List<? extends ContractualTermsSupplement.ContractualTermsSupplementBuilder> getContractualTermsSupplement() {
			return contractualTermsSupplement;
		}
		
		public ContractualTermsSupplement.ContractualTermsSupplementBuilder getOrCreateContractualTermsSupplement(int _index) {
		
			if (contractualTermsSupplement==null) {
				this.contractualTermsSupplement = new ArrayList<>();
			}
			ContractualTermsSupplement.ContractualTermsSupplementBuilder result;
			return getIndex(contractualTermsSupplement, _index, () -> {
						ContractualTermsSupplement.ContractualTermsSupplementBuilder newContractualTermsSupplement = ContractualTermsSupplement.builder();
						return newContractualTermsSupplement;
					});
		}
		
		@Override
		@RosettaAttribute("contractualMatrix")
		public List<? extends ContractualMatrix.ContractualMatrixBuilder> getContractualMatrix() {
			return contractualMatrix;
		}
		
		public ContractualMatrix.ContractualMatrixBuilder getOrCreateContractualMatrix(int _index) {
		
			if (contractualMatrix==null) {
				this.contractualMatrix = new ArrayList<>();
			}
			ContractualMatrix.ContractualMatrixBuilder result;
			return getIndex(contractualMatrix, _index, () -> {
						ContractualMatrix.ContractualMatrixBuilder newContractualMatrix = ContractualMatrix.builder();
						return newContractualMatrix;
					});
		}
		
		@Override
		@RosettaAttribute("creditSupportAgreement")
		public CreditSupportAgreement.CreditSupportAgreementBuilder getCreditSupportAgreement() {
			return creditSupportAgreement;
		}
		
		@Override
		public CreditSupportAgreement.CreditSupportAgreementBuilder getOrCreateCreditSupportAgreement() {
			CreditSupportAgreement.CreditSupportAgreementBuilder result;
			if (creditSupportAgreement!=null) {
				result = creditSupportAgreement;
			}
			else {
				result = creditSupportAgreement = CreditSupportAgreement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("otherAgreement")
		public List<? extends OtherAgreement.OtherAgreementBuilder> getOtherAgreement() {
			return otherAgreement;
		}
		
		public OtherAgreement.OtherAgreementBuilder getOrCreateOtherAgreement(int _index) {
		
			if (otherAgreement==null) {
				this.otherAgreement = new ArrayList<>();
			}
			OtherAgreement.OtherAgreementBuilder result;
			return getIndex(otherAgreement, _index, () -> {
						OtherAgreement.OtherAgreementBuilder newOtherAgreement = OtherAgreement.builder();
						return newOtherAgreement;
					});
		}
		
		@Override
		@RosettaAttribute("attachment")
		public List<? extends Resource.ResourceBuilder> getAttachment() {
			return attachment;
		}
		
		public Resource.ResourceBuilder getOrCreateAttachment(int _index) {
		
			if (attachment==null) {
				this.attachment = new ArrayList<>();
			}
			Resource.ResourceBuilder result;
			return getIndex(attachment, _index, () -> {
						Resource.ResourceBuilder newAttachment = Resource.builder();
						return newAttachment;
					});
		}
		
		@Override
		@RosettaAttribute("masterAgreement")
		public Documentation.DocumentationBuilder setMasterAgreement(MasterAgreement masterAgreement) {
			this.masterAgreement = masterAgreement==null?null:masterAgreement.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("masterConfirmation")
		public Documentation.DocumentationBuilder setMasterConfirmation(MasterConfirmation masterConfirmation) {
			this.masterConfirmation = masterConfirmation==null?null:masterConfirmation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("brokerConfirmation")
		public Documentation.DocumentationBuilder setBrokerConfirmation(BrokerConfirmation brokerConfirmation) {
			this.brokerConfirmation = brokerConfirmation==null?null:brokerConfirmation.toBuilder();
			return this;
		}
		@Override
		public Documentation.DocumentationBuilder addContractualDefinitions(ContractualDefinitions contractualDefinitions) {
			if (contractualDefinitions!=null) this.contractualDefinitions.add(contractualDefinitions.toBuilder());
			return this;
		}
		
		@Override
		public Documentation.DocumentationBuilder addContractualDefinitions(ContractualDefinitions contractualDefinitions, int _idx) {
			getIndex(this.contractualDefinitions, _idx, () -> contractualDefinitions.toBuilder());
			return this;
		}
		@Override 
		public Documentation.DocumentationBuilder addContractualDefinitions(List<? extends ContractualDefinitions> contractualDefinitionss) {
			if (contractualDefinitionss != null) {
				for (ContractualDefinitions toAdd : contractualDefinitionss) {
					this.contractualDefinitions.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("contractualDefinitions")
		public Documentation.DocumentationBuilder setContractualDefinitions(List<? extends ContractualDefinitions> contractualDefinitionss) {
			if (contractualDefinitionss == null)  {
				this.contractualDefinitions = new ArrayList<>();
			}
			else {
				this.contractualDefinitions = contractualDefinitionss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Documentation.DocumentationBuilder addContractualTermsSupplement(ContractualTermsSupplement contractualTermsSupplement) {
			if (contractualTermsSupplement!=null) this.contractualTermsSupplement.add(contractualTermsSupplement.toBuilder());
			return this;
		}
		
		@Override
		public Documentation.DocumentationBuilder addContractualTermsSupplement(ContractualTermsSupplement contractualTermsSupplement, int _idx) {
			getIndex(this.contractualTermsSupplement, _idx, () -> contractualTermsSupplement.toBuilder());
			return this;
		}
		@Override 
		public Documentation.DocumentationBuilder addContractualTermsSupplement(List<? extends ContractualTermsSupplement> contractualTermsSupplements) {
			if (contractualTermsSupplements != null) {
				for (ContractualTermsSupplement toAdd : contractualTermsSupplements) {
					this.contractualTermsSupplement.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("contractualTermsSupplement")
		public Documentation.DocumentationBuilder setContractualTermsSupplement(List<? extends ContractualTermsSupplement> contractualTermsSupplements) {
			if (contractualTermsSupplements == null)  {
				this.contractualTermsSupplement = new ArrayList<>();
			}
			else {
				this.contractualTermsSupplement = contractualTermsSupplements.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Documentation.DocumentationBuilder addContractualMatrix(ContractualMatrix contractualMatrix) {
			if (contractualMatrix!=null) this.contractualMatrix.add(contractualMatrix.toBuilder());
			return this;
		}
		
		@Override
		public Documentation.DocumentationBuilder addContractualMatrix(ContractualMatrix contractualMatrix, int _idx) {
			getIndex(this.contractualMatrix, _idx, () -> contractualMatrix.toBuilder());
			return this;
		}
		@Override 
		public Documentation.DocumentationBuilder addContractualMatrix(List<? extends ContractualMatrix> contractualMatrixs) {
			if (contractualMatrixs != null) {
				for (ContractualMatrix toAdd : contractualMatrixs) {
					this.contractualMatrix.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("contractualMatrix")
		public Documentation.DocumentationBuilder setContractualMatrix(List<? extends ContractualMatrix> contractualMatrixs) {
			if (contractualMatrixs == null)  {
				this.contractualMatrix = new ArrayList<>();
			}
			else {
				this.contractualMatrix = contractualMatrixs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("creditSupportAgreement")
		public Documentation.DocumentationBuilder setCreditSupportAgreement(CreditSupportAgreement creditSupportAgreement) {
			this.creditSupportAgreement = creditSupportAgreement==null?null:creditSupportAgreement.toBuilder();
			return this;
		}
		@Override
		public Documentation.DocumentationBuilder addOtherAgreement(OtherAgreement otherAgreement) {
			if (otherAgreement!=null) this.otherAgreement.add(otherAgreement.toBuilder());
			return this;
		}
		
		@Override
		public Documentation.DocumentationBuilder addOtherAgreement(OtherAgreement otherAgreement, int _idx) {
			getIndex(this.otherAgreement, _idx, () -> otherAgreement.toBuilder());
			return this;
		}
		@Override 
		public Documentation.DocumentationBuilder addOtherAgreement(List<? extends OtherAgreement> otherAgreements) {
			if (otherAgreements != null) {
				for (OtherAgreement toAdd : otherAgreements) {
					this.otherAgreement.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("otherAgreement")
		public Documentation.DocumentationBuilder setOtherAgreement(List<? extends OtherAgreement> otherAgreements) {
			if (otherAgreements == null)  {
				this.otherAgreement = new ArrayList<>();
			}
			else {
				this.otherAgreement = otherAgreements.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Documentation.DocumentationBuilder addAttachment(Resource attachment) {
			if (attachment!=null) this.attachment.add(attachment.toBuilder());
			return this;
		}
		
		@Override
		public Documentation.DocumentationBuilder addAttachment(Resource attachment, int _idx) {
			getIndex(this.attachment, _idx, () -> attachment.toBuilder());
			return this;
		}
		@Override 
		public Documentation.DocumentationBuilder addAttachment(List<? extends Resource> attachments) {
			if (attachments != null) {
				for (Resource toAdd : attachments) {
					this.attachment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("attachment")
		public Documentation.DocumentationBuilder setAttachment(List<? extends Resource> attachments) {
			if (attachments == null)  {
				this.attachment = new ArrayList<>();
			}
			else {
				this.attachment = attachments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public Documentation build() {
			return new Documentation.DocumentationImpl(this);
		}
		
		@Override
		public Documentation.DocumentationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Documentation.DocumentationBuilder prune() {
			if (masterAgreement!=null && !masterAgreement.prune().hasData()) masterAgreement = null;
			if (masterConfirmation!=null && !masterConfirmation.prune().hasData()) masterConfirmation = null;
			if (brokerConfirmation!=null && !brokerConfirmation.prune().hasData()) brokerConfirmation = null;
			contractualDefinitions = contractualDefinitions.stream().filter(b->b!=null).<ContractualDefinitions.ContractualDefinitionsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			contractualTermsSupplement = contractualTermsSupplement.stream().filter(b->b!=null).<ContractualTermsSupplement.ContractualTermsSupplementBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			contractualMatrix = contractualMatrix.stream().filter(b->b!=null).<ContractualMatrix.ContractualMatrixBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (creditSupportAgreement!=null && !creditSupportAgreement.prune().hasData()) creditSupportAgreement = null;
			otherAgreement = otherAgreement.stream().filter(b->b!=null).<OtherAgreement.OtherAgreementBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			attachment = attachment.stream().filter(b->b!=null).<Resource.ResourceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMasterAgreement()!=null && getMasterAgreement().hasData()) return true;
			if (getMasterConfirmation()!=null && getMasterConfirmation().hasData()) return true;
			if (getBrokerConfirmation()!=null && getBrokerConfirmation().hasData()) return true;
			if (getContractualDefinitions()!=null && getContractualDefinitions().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getContractualTermsSupplement()!=null && getContractualTermsSupplement().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getContractualMatrix()!=null && getContractualMatrix().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCreditSupportAgreement()!=null && getCreditSupportAgreement().hasData()) return true;
			if (getOtherAgreement()!=null && getOtherAgreement().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAttachment()!=null && getAttachment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Documentation.DocumentationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Documentation.DocumentationBuilder o = (Documentation.DocumentationBuilder) other;
			
			merger.mergeRosetta(getMasterAgreement(), o.getMasterAgreement(), this::setMasterAgreement);
			merger.mergeRosetta(getMasterConfirmation(), o.getMasterConfirmation(), this::setMasterConfirmation);
			merger.mergeRosetta(getBrokerConfirmation(), o.getBrokerConfirmation(), this::setBrokerConfirmation);
			merger.mergeRosetta(getContractualDefinitions(), o.getContractualDefinitions(), this::getOrCreateContractualDefinitions);
			merger.mergeRosetta(getContractualTermsSupplement(), o.getContractualTermsSupplement(), this::getOrCreateContractualTermsSupplement);
			merger.mergeRosetta(getContractualMatrix(), o.getContractualMatrix(), this::getOrCreateContractualMatrix);
			merger.mergeRosetta(getCreditSupportAgreement(), o.getCreditSupportAgreement(), this::setCreditSupportAgreement);
			merger.mergeRosetta(getOtherAgreement(), o.getOtherAgreement(), this::getOrCreateOtherAgreement);
			merger.mergeRosetta(getAttachment(), o.getAttachment(), this::getOrCreateAttachment);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Documentation _that = getType().cast(o);
		
			if (!Objects.equals(masterAgreement, _that.getMasterAgreement())) return false;
			if (!Objects.equals(masterConfirmation, _that.getMasterConfirmation())) return false;
			if (!Objects.equals(brokerConfirmation, _that.getBrokerConfirmation())) return false;
			if (!ListEquals.listEquals(contractualDefinitions, _that.getContractualDefinitions())) return false;
			if (!ListEquals.listEquals(contractualTermsSupplement, _that.getContractualTermsSupplement())) return false;
			if (!ListEquals.listEquals(contractualMatrix, _that.getContractualMatrix())) return false;
			if (!Objects.equals(creditSupportAgreement, _that.getCreditSupportAgreement())) return false;
			if (!ListEquals.listEquals(otherAgreement, _that.getOtherAgreement())) return false;
			if (!ListEquals.listEquals(attachment, _that.getAttachment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (masterAgreement != null ? masterAgreement.hashCode() : 0);
			_result = 31 * _result + (masterConfirmation != null ? masterConfirmation.hashCode() : 0);
			_result = 31 * _result + (brokerConfirmation != null ? brokerConfirmation.hashCode() : 0);
			_result = 31 * _result + (contractualDefinitions != null ? contractualDefinitions.hashCode() : 0);
			_result = 31 * _result + (contractualTermsSupplement != null ? contractualTermsSupplement.hashCode() : 0);
			_result = 31 * _result + (contractualMatrix != null ? contractualMatrix.hashCode() : 0);
			_result = 31 * _result + (creditSupportAgreement != null ? creditSupportAgreement.hashCode() : 0);
			_result = 31 * _result + (otherAgreement != null ? otherAgreement.hashCode() : 0);
			_result = 31 * _result + (attachment != null ? attachment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DocumentationBuilder {" +
				"masterAgreement=" + this.masterAgreement + ", " +
				"masterConfirmation=" + this.masterConfirmation + ", " +
				"brokerConfirmation=" + this.brokerConfirmation + ", " +
				"contractualDefinitions=" + this.contractualDefinitions + ", " +
				"contractualTermsSupplement=" + this.contractualTermsSupplement + ", " +
				"contractualMatrix=" + this.contractualMatrix + ", " +
				"creditSupportAgreement=" + this.creditSupportAgreement + ", " +
				"otherAgreement=" + this.otherAgreement + ", " +
				"attachment=" + this.attachment +
			'}';
		}
	}
}
