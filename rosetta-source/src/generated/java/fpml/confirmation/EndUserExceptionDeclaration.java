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
import fpml.confirmation.CreditDocument;
import fpml.confirmation.EndUserExceptionDeclaration;
import fpml.confirmation.EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder;
import fpml.confirmation.EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilderImpl;
import fpml.confirmation.EndUserExceptionDeclaration.EndUserExceptionDeclarationImpl;
import fpml.confirmation.OrganizationCharacteristic;
import fpml.confirmation.SupervisorRegistration;
import fpml.confirmation.TransactionCharacteristic;
import fpml.confirmation.meta.EndUserExceptionDeclarationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Records supporting information justifying an end user exception under 17 CFR part 39.
 * @version ${project.version}
 */
@RosettaDataType(value="EndUserExceptionDeclaration", builder=EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilderImpl.class, version="${project.version}")
public interface EndUserExceptionDeclaration extends RosettaModelObject {

	EndUserExceptionDeclarationMeta metaData = new EndUserExceptionDeclarationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * What arrangements will be made to provide credit? (e.g. CSA, collateral pledge, guaranty, available resources, financing).
	 */
	List<? extends CreditDocument> getCreditDocument();
	/**
	 * Allows the organization to specify which categories or characteristics apply to it for end-user exception determination. Examples include &quot;FinancialEntity&quot;, &quot;CaptiveFinanceUnit&quot;, &quot;BoardOfDirectorsApproval&quot;.
	 */
	List<? extends OrganizationCharacteristic> getOrganizationCharacteristic();
	/**
	 * Allows the relevant transaction level categories or characteristics to be recorded for end-user exception determination. Examples include &quot;BoardOfDirectorsApproval&quot;, &quot;HedgesCommercialRisk&quot;.
	 */
	List<? extends TransactionCharacteristic> getTransactionCharacteristic();
	/**
	 * Allows the organization to specify which if any relevant regulators it is registered with, and if so their identification number. For example, it could specify that it is SEC registered and provide its Central Index Key.
	 */
	List<? extends SupervisorRegistration> getSupervisorRegistration();

	/*********************** Build Methods  ***********************/
	EndUserExceptionDeclaration build();
	
	EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder toBuilder();
	
	static EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder builder() {
		return new EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EndUserExceptionDeclaration> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EndUserExceptionDeclaration> getType() {
		return EndUserExceptionDeclaration.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("creditDocument"), processor, CreditDocument.class, getCreditDocument());
		processRosetta(path.newSubPath("organizationCharacteristic"), processor, OrganizationCharacteristic.class, getOrganizationCharacteristic());
		processRosetta(path.newSubPath("transactionCharacteristic"), processor, TransactionCharacteristic.class, getTransactionCharacteristic());
		processRosetta(path.newSubPath("supervisorRegistration"), processor, SupervisorRegistration.class, getSupervisorRegistration());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EndUserExceptionDeclarationBuilder extends EndUserExceptionDeclaration, RosettaModelObjectBuilder {
		CreditDocument.CreditDocumentBuilder getOrCreateCreditDocument(int _index);
		List<? extends CreditDocument.CreditDocumentBuilder> getCreditDocument();
		OrganizationCharacteristic.OrganizationCharacteristicBuilder getOrCreateOrganizationCharacteristic(int _index);
		List<? extends OrganizationCharacteristic.OrganizationCharacteristicBuilder> getOrganizationCharacteristic();
		TransactionCharacteristic.TransactionCharacteristicBuilder getOrCreateTransactionCharacteristic(int _index);
		List<? extends TransactionCharacteristic.TransactionCharacteristicBuilder> getTransactionCharacteristic();
		SupervisorRegistration.SupervisorRegistrationBuilder getOrCreateSupervisorRegistration(int _index);
		List<? extends SupervisorRegistration.SupervisorRegistrationBuilder> getSupervisorRegistration();
		EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder addCreditDocument(CreditDocument creditDocument0);
		EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder addCreditDocument(CreditDocument creditDocument1, int _idx);
		EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder addCreditDocument(List<? extends CreditDocument> creditDocument2);
		EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder setCreditDocument(List<? extends CreditDocument> creditDocument3);
		EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder addOrganizationCharacteristic(OrganizationCharacteristic organizationCharacteristic0);
		EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder addOrganizationCharacteristic(OrganizationCharacteristic organizationCharacteristic1, int _idx);
		EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder addOrganizationCharacteristic(List<? extends OrganizationCharacteristic> organizationCharacteristic2);
		EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder setOrganizationCharacteristic(List<? extends OrganizationCharacteristic> organizationCharacteristic3);
		EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder addTransactionCharacteristic(TransactionCharacteristic transactionCharacteristic0);
		EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder addTransactionCharacteristic(TransactionCharacteristic transactionCharacteristic1, int _idx);
		EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder addTransactionCharacteristic(List<? extends TransactionCharacteristic> transactionCharacteristic2);
		EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder setTransactionCharacteristic(List<? extends TransactionCharacteristic> transactionCharacteristic3);
		EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder addSupervisorRegistration(SupervisorRegistration supervisorRegistration0);
		EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder addSupervisorRegistration(SupervisorRegistration supervisorRegistration1, int _idx);
		EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder addSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistration2);
		EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder setSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistration3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("creditDocument"), processor, CreditDocument.CreditDocumentBuilder.class, getCreditDocument());
			processRosetta(path.newSubPath("organizationCharacteristic"), processor, OrganizationCharacteristic.OrganizationCharacteristicBuilder.class, getOrganizationCharacteristic());
			processRosetta(path.newSubPath("transactionCharacteristic"), processor, TransactionCharacteristic.TransactionCharacteristicBuilder.class, getTransactionCharacteristic());
			processRosetta(path.newSubPath("supervisorRegistration"), processor, SupervisorRegistration.SupervisorRegistrationBuilder.class, getSupervisorRegistration());
		}
		

		EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder prune();
	}

	/*********************** Immutable Implementation of EndUserExceptionDeclaration  ***********************/
	class EndUserExceptionDeclarationImpl implements EndUserExceptionDeclaration {
		private final List<? extends CreditDocument> creditDocument;
		private final List<? extends OrganizationCharacteristic> organizationCharacteristic;
		private final List<? extends TransactionCharacteristic> transactionCharacteristic;
		private final List<? extends SupervisorRegistration> supervisorRegistration;
		
		protected EndUserExceptionDeclarationImpl(EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder builder) {
			this.creditDocument = ofNullable(builder.getCreditDocument()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.organizationCharacteristic = ofNullable(builder.getOrganizationCharacteristic()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.transactionCharacteristic = ofNullable(builder.getTransactionCharacteristic()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.supervisorRegistration = ofNullable(builder.getSupervisorRegistration()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("creditDocument")
		public List<? extends CreditDocument> getCreditDocument() {
			return creditDocument;
		}
		
		@Override
		@RosettaAttribute("organizationCharacteristic")
		public List<? extends OrganizationCharacteristic> getOrganizationCharacteristic() {
			return organizationCharacteristic;
		}
		
		@Override
		@RosettaAttribute("transactionCharacteristic")
		public List<? extends TransactionCharacteristic> getTransactionCharacteristic() {
			return transactionCharacteristic;
		}
		
		@Override
		@RosettaAttribute("supervisorRegistration")
		public List<? extends SupervisorRegistration> getSupervisorRegistration() {
			return supervisorRegistration;
		}
		
		@Override
		public EndUserExceptionDeclaration build() {
			return this;
		}
		
		@Override
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder toBuilder() {
			EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder builder) {
			ofNullable(getCreditDocument()).ifPresent(builder::setCreditDocument);
			ofNullable(getOrganizationCharacteristic()).ifPresent(builder::setOrganizationCharacteristic);
			ofNullable(getTransactionCharacteristic()).ifPresent(builder::setTransactionCharacteristic);
			ofNullable(getSupervisorRegistration()).ifPresent(builder::setSupervisorRegistration);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EndUserExceptionDeclaration _that = getType().cast(o);
		
			if (!ListEquals.listEquals(creditDocument, _that.getCreditDocument())) return false;
			if (!ListEquals.listEquals(organizationCharacteristic, _that.getOrganizationCharacteristic())) return false;
			if (!ListEquals.listEquals(transactionCharacteristic, _that.getTransactionCharacteristic())) return false;
			if (!ListEquals.listEquals(supervisorRegistration, _that.getSupervisorRegistration())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditDocument != null ? creditDocument.hashCode() : 0);
			_result = 31 * _result + (organizationCharacteristic != null ? organizationCharacteristic.hashCode() : 0);
			_result = 31 * _result + (transactionCharacteristic != null ? transactionCharacteristic.hashCode() : 0);
			_result = 31 * _result + (supervisorRegistration != null ? supervisorRegistration.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EndUserExceptionDeclaration {" +
				"creditDocument=" + this.creditDocument + ", " +
				"organizationCharacteristic=" + this.organizationCharacteristic + ", " +
				"transactionCharacteristic=" + this.transactionCharacteristic + ", " +
				"supervisorRegistration=" + this.supervisorRegistration +
			'}';
		}
	}

	/*********************** Builder Implementation of EndUserExceptionDeclaration  ***********************/
	class EndUserExceptionDeclarationBuilderImpl implements EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder {
	
		protected List<CreditDocument.CreditDocumentBuilder> creditDocument = new ArrayList<>();
		protected List<OrganizationCharacteristic.OrganizationCharacteristicBuilder> organizationCharacteristic = new ArrayList<>();
		protected List<TransactionCharacteristic.TransactionCharacteristicBuilder> transactionCharacteristic = new ArrayList<>();
		protected List<SupervisorRegistration.SupervisorRegistrationBuilder> supervisorRegistration = new ArrayList<>();
	
		public EndUserExceptionDeclarationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("creditDocument")
		public List<? extends CreditDocument.CreditDocumentBuilder> getCreditDocument() {
			return creditDocument;
		}
		
		public CreditDocument.CreditDocumentBuilder getOrCreateCreditDocument(int _index) {
		
			if (creditDocument==null) {
				this.creditDocument = new ArrayList<>();
			}
			CreditDocument.CreditDocumentBuilder result;
			return getIndex(creditDocument, _index, () -> {
						CreditDocument.CreditDocumentBuilder newCreditDocument = CreditDocument.builder();
						return newCreditDocument;
					});
		}
		
		@Override
		@RosettaAttribute("organizationCharacteristic")
		public List<? extends OrganizationCharacteristic.OrganizationCharacteristicBuilder> getOrganizationCharacteristic() {
			return organizationCharacteristic;
		}
		
		public OrganizationCharacteristic.OrganizationCharacteristicBuilder getOrCreateOrganizationCharacteristic(int _index) {
		
			if (organizationCharacteristic==null) {
				this.organizationCharacteristic = new ArrayList<>();
			}
			OrganizationCharacteristic.OrganizationCharacteristicBuilder result;
			return getIndex(organizationCharacteristic, _index, () -> {
						OrganizationCharacteristic.OrganizationCharacteristicBuilder newOrganizationCharacteristic = OrganizationCharacteristic.builder();
						return newOrganizationCharacteristic;
					});
		}
		
		@Override
		@RosettaAttribute("transactionCharacteristic")
		public List<? extends TransactionCharacteristic.TransactionCharacteristicBuilder> getTransactionCharacteristic() {
			return transactionCharacteristic;
		}
		
		public TransactionCharacteristic.TransactionCharacteristicBuilder getOrCreateTransactionCharacteristic(int _index) {
		
			if (transactionCharacteristic==null) {
				this.transactionCharacteristic = new ArrayList<>();
			}
			TransactionCharacteristic.TransactionCharacteristicBuilder result;
			return getIndex(transactionCharacteristic, _index, () -> {
						TransactionCharacteristic.TransactionCharacteristicBuilder newTransactionCharacteristic = TransactionCharacteristic.builder();
						return newTransactionCharacteristic;
					});
		}
		
		@Override
		@RosettaAttribute("supervisorRegistration")
		public List<? extends SupervisorRegistration.SupervisorRegistrationBuilder> getSupervisorRegistration() {
			return supervisorRegistration;
		}
		
		public SupervisorRegistration.SupervisorRegistrationBuilder getOrCreateSupervisorRegistration(int _index) {
		
			if (supervisorRegistration==null) {
				this.supervisorRegistration = new ArrayList<>();
			}
			SupervisorRegistration.SupervisorRegistrationBuilder result;
			return getIndex(supervisorRegistration, _index, () -> {
						SupervisorRegistration.SupervisorRegistrationBuilder newSupervisorRegistration = SupervisorRegistration.builder();
						return newSupervisorRegistration;
					});
		}
		
		@Override
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder addCreditDocument(CreditDocument creditDocument) {
			if (creditDocument!=null) this.creditDocument.add(creditDocument.toBuilder());
			return this;
		}
		
		@Override
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder addCreditDocument(CreditDocument creditDocument, int _idx) {
			getIndex(this.creditDocument, _idx, () -> creditDocument.toBuilder());
			return this;
		}
		@Override 
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder addCreditDocument(List<? extends CreditDocument> creditDocuments) {
			if (creditDocuments != null) {
				for (CreditDocument toAdd : creditDocuments) {
					this.creditDocument.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("creditDocument")
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder setCreditDocument(List<? extends CreditDocument> creditDocuments) {
			if (creditDocuments == null)  {
				this.creditDocument = new ArrayList<>();
			}
			else {
				this.creditDocument = creditDocuments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder addOrganizationCharacteristic(OrganizationCharacteristic organizationCharacteristic) {
			if (organizationCharacteristic!=null) this.organizationCharacteristic.add(organizationCharacteristic.toBuilder());
			return this;
		}
		
		@Override
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder addOrganizationCharacteristic(OrganizationCharacteristic organizationCharacteristic, int _idx) {
			getIndex(this.organizationCharacteristic, _idx, () -> organizationCharacteristic.toBuilder());
			return this;
		}
		@Override 
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder addOrganizationCharacteristic(List<? extends OrganizationCharacteristic> organizationCharacteristics) {
			if (organizationCharacteristics != null) {
				for (OrganizationCharacteristic toAdd : organizationCharacteristics) {
					this.organizationCharacteristic.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("organizationCharacteristic")
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder setOrganizationCharacteristic(List<? extends OrganizationCharacteristic> organizationCharacteristics) {
			if (organizationCharacteristics == null)  {
				this.organizationCharacteristic = new ArrayList<>();
			}
			else {
				this.organizationCharacteristic = organizationCharacteristics.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder addTransactionCharacteristic(TransactionCharacteristic transactionCharacteristic) {
			if (transactionCharacteristic!=null) this.transactionCharacteristic.add(transactionCharacteristic.toBuilder());
			return this;
		}
		
		@Override
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder addTransactionCharacteristic(TransactionCharacteristic transactionCharacteristic, int _idx) {
			getIndex(this.transactionCharacteristic, _idx, () -> transactionCharacteristic.toBuilder());
			return this;
		}
		@Override 
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder addTransactionCharacteristic(List<? extends TransactionCharacteristic> transactionCharacteristics) {
			if (transactionCharacteristics != null) {
				for (TransactionCharacteristic toAdd : transactionCharacteristics) {
					this.transactionCharacteristic.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("transactionCharacteristic")
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder setTransactionCharacteristic(List<? extends TransactionCharacteristic> transactionCharacteristics) {
			if (transactionCharacteristics == null)  {
				this.transactionCharacteristic = new ArrayList<>();
			}
			else {
				this.transactionCharacteristic = transactionCharacteristics.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder addSupervisorRegistration(SupervisorRegistration supervisorRegistration) {
			if (supervisorRegistration!=null) this.supervisorRegistration.add(supervisorRegistration.toBuilder());
			return this;
		}
		
		@Override
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder addSupervisorRegistration(SupervisorRegistration supervisorRegistration, int _idx) {
			getIndex(this.supervisorRegistration, _idx, () -> supervisorRegistration.toBuilder());
			return this;
		}
		@Override 
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder addSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistrations) {
			if (supervisorRegistrations != null) {
				for (SupervisorRegistration toAdd : supervisorRegistrations) {
					this.supervisorRegistration.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("supervisorRegistration")
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder setSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistrations) {
			if (supervisorRegistrations == null)  {
				this.supervisorRegistration = new ArrayList<>();
			}
			else {
				this.supervisorRegistration = supervisorRegistrations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public EndUserExceptionDeclaration build() {
			return new EndUserExceptionDeclaration.EndUserExceptionDeclarationImpl(this);
		}
		
		@Override
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder prune() {
			creditDocument = creditDocument.stream().filter(b->b!=null).<CreditDocument.CreditDocumentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			organizationCharacteristic = organizationCharacteristic.stream().filter(b->b!=null).<OrganizationCharacteristic.OrganizationCharacteristicBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			transactionCharacteristic = transactionCharacteristic.stream().filter(b->b!=null).<TransactionCharacteristic.TransactionCharacteristicBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			supervisorRegistration = supervisorRegistration.stream().filter(b->b!=null).<SupervisorRegistration.SupervisorRegistrationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCreditDocument()!=null && getCreditDocument().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOrganizationCharacteristic()!=null && getOrganizationCharacteristic().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTransactionCharacteristic()!=null && getTransactionCharacteristic().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSupervisorRegistration()!=null && getSupervisorRegistration().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder o = (EndUserExceptionDeclaration.EndUserExceptionDeclarationBuilder) other;
			
			merger.mergeRosetta(getCreditDocument(), o.getCreditDocument(), this::getOrCreateCreditDocument);
			merger.mergeRosetta(getOrganizationCharacteristic(), o.getOrganizationCharacteristic(), this::getOrCreateOrganizationCharacteristic);
			merger.mergeRosetta(getTransactionCharacteristic(), o.getTransactionCharacteristic(), this::getOrCreateTransactionCharacteristic);
			merger.mergeRosetta(getSupervisorRegistration(), o.getSupervisorRegistration(), this::getOrCreateSupervisorRegistration);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EndUserExceptionDeclaration _that = getType().cast(o);
		
			if (!ListEquals.listEquals(creditDocument, _that.getCreditDocument())) return false;
			if (!ListEquals.listEquals(organizationCharacteristic, _that.getOrganizationCharacteristic())) return false;
			if (!ListEquals.listEquals(transactionCharacteristic, _that.getTransactionCharacteristic())) return false;
			if (!ListEquals.listEquals(supervisorRegistration, _that.getSupervisorRegistration())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditDocument != null ? creditDocument.hashCode() : 0);
			_result = 31 * _result + (organizationCharacteristic != null ? organizationCharacteristic.hashCode() : 0);
			_result = 31 * _result + (transactionCharacteristic != null ? transactionCharacteristic.hashCode() : 0);
			_result = 31 * _result + (supervisorRegistration != null ? supervisorRegistration.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EndUserExceptionDeclarationBuilder {" +
				"creditDocument=" + this.creditDocument + ", " +
				"organizationCharacteristic=" + this.organizationCharacteristic + ", " +
				"transactionCharacteristic=" + this.transactionCharacteristic + ", " +
				"supervisorRegistration=" + this.supervisorRegistration +
			'}';
		}
	}
}
