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
import fpml.confirmation.FacilityExecutionExceptionDeclaration;
import fpml.confirmation.FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder;
import fpml.confirmation.FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilderImpl;
import fpml.confirmation.FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationImpl;
import fpml.confirmation.OrganizationCharacteristic;
import fpml.confirmation.SupervisorRegistration;
import fpml.confirmation.TransactionCharacteristic;
import fpml.confirmation.meta.FacilityExecutionExceptionDeclarationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Provides supporting evidence when a party invoked exception to not execute the trade on facility such as SEF and DCM even though the particular product is mandated to execute on a SEF.
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityExecutionExceptionDeclaration", builder=FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilderImpl.class, version="${project.version}")
public interface FacilityExecutionExceptionDeclaration extends RosettaModelObject {

	FacilityExecutionExceptionDeclarationMeta metaData = new FacilityExecutionExceptionDeclarationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Reason for not executing the trade on SEF or other facility.
	 */
	List<String> getReason();
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
	FacilityExecutionExceptionDeclaration build();
	
	FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder toBuilder();
	
	static FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder builder() {
		return new FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityExecutionExceptionDeclaration> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityExecutionExceptionDeclaration> getType() {
		return FacilityExecutionExceptionDeclaration.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("reason"), String.class, getReason(), this);
		processRosetta(path.newSubPath("organizationCharacteristic"), processor, OrganizationCharacteristic.class, getOrganizationCharacteristic());
		processRosetta(path.newSubPath("transactionCharacteristic"), processor, TransactionCharacteristic.class, getTransactionCharacteristic());
		processRosetta(path.newSubPath("supervisorRegistration"), processor, SupervisorRegistration.class, getSupervisorRegistration());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityExecutionExceptionDeclarationBuilder extends FacilityExecutionExceptionDeclaration, RosettaModelObjectBuilder {
		OrganizationCharacteristic.OrganizationCharacteristicBuilder getOrCreateOrganizationCharacteristic(int _index);
		List<? extends OrganizationCharacteristic.OrganizationCharacteristicBuilder> getOrganizationCharacteristic();
		TransactionCharacteristic.TransactionCharacteristicBuilder getOrCreateTransactionCharacteristic(int _index);
		List<? extends TransactionCharacteristic.TransactionCharacteristicBuilder> getTransactionCharacteristic();
		SupervisorRegistration.SupervisorRegistrationBuilder getOrCreateSupervisorRegistration(int _index);
		List<? extends SupervisorRegistration.SupervisorRegistrationBuilder> getSupervisorRegistration();
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addReason(String reason0);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addReason(String reason1, int _idx);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addReason(List<String> reason2);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder setReason(List<String> reason3);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addOrganizationCharacteristic(OrganizationCharacteristic organizationCharacteristic0);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addOrganizationCharacteristic(OrganizationCharacteristic organizationCharacteristic1, int _idx);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addOrganizationCharacteristic(List<? extends OrganizationCharacteristic> organizationCharacteristic2);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder setOrganizationCharacteristic(List<? extends OrganizationCharacteristic> organizationCharacteristic3);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addTransactionCharacteristic(TransactionCharacteristic transactionCharacteristic0);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addTransactionCharacteristic(TransactionCharacteristic transactionCharacteristic1, int _idx);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addTransactionCharacteristic(List<? extends TransactionCharacteristic> transactionCharacteristic2);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder setTransactionCharacteristic(List<? extends TransactionCharacteristic> transactionCharacteristic3);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addSupervisorRegistration(SupervisorRegistration supervisorRegistration0);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addSupervisorRegistration(SupervisorRegistration supervisorRegistration1, int _idx);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistration2);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder setSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistration3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("reason"), String.class, getReason(), this);
			processRosetta(path.newSubPath("organizationCharacteristic"), processor, OrganizationCharacteristic.OrganizationCharacteristicBuilder.class, getOrganizationCharacteristic());
			processRosetta(path.newSubPath("transactionCharacteristic"), processor, TransactionCharacteristic.TransactionCharacteristicBuilder.class, getTransactionCharacteristic());
			processRosetta(path.newSubPath("supervisorRegistration"), processor, SupervisorRegistration.SupervisorRegistrationBuilder.class, getSupervisorRegistration());
		}
		

		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityExecutionExceptionDeclaration  ***********************/
	class FacilityExecutionExceptionDeclarationImpl implements FacilityExecutionExceptionDeclaration {
		private final List<String> reason;
		private final List<? extends OrganizationCharacteristic> organizationCharacteristic;
		private final List<? extends TransactionCharacteristic> transactionCharacteristic;
		private final List<? extends SupervisorRegistration> supervisorRegistration;
		
		protected FacilityExecutionExceptionDeclarationImpl(FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder builder) {
			this.reason = ofNullable(builder.getReason()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.organizationCharacteristic = ofNullable(builder.getOrganizationCharacteristic()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.transactionCharacteristic = ofNullable(builder.getTransactionCharacteristic()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.supervisorRegistration = ofNullable(builder.getSupervisorRegistration()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("reason")
		public List<String> getReason() {
			return reason;
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
		public FacilityExecutionExceptionDeclaration build() {
			return this;
		}
		
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder toBuilder() {
			FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder builder) {
			ofNullable(getReason()).ifPresent(builder::setReason);
			ofNullable(getOrganizationCharacteristic()).ifPresent(builder::setOrganizationCharacteristic);
			ofNullable(getTransactionCharacteristic()).ifPresent(builder::setTransactionCharacteristic);
			ofNullable(getSupervisorRegistration()).ifPresent(builder::setSupervisorRegistration);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityExecutionExceptionDeclaration _that = getType().cast(o);
		
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			if (!ListEquals.listEquals(organizationCharacteristic, _that.getOrganizationCharacteristic())) return false;
			if (!ListEquals.listEquals(transactionCharacteristic, _that.getTransactionCharacteristic())) return false;
			if (!ListEquals.listEquals(supervisorRegistration, _that.getSupervisorRegistration())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			_result = 31 * _result + (organizationCharacteristic != null ? organizationCharacteristic.hashCode() : 0);
			_result = 31 * _result + (transactionCharacteristic != null ? transactionCharacteristic.hashCode() : 0);
			_result = 31 * _result + (supervisorRegistration != null ? supervisorRegistration.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityExecutionExceptionDeclaration {" +
				"reason=" + this.reason + ", " +
				"organizationCharacteristic=" + this.organizationCharacteristic + ", " +
				"transactionCharacteristic=" + this.transactionCharacteristic + ", " +
				"supervisorRegistration=" + this.supervisorRegistration +
			'}';
		}
	}

	/*********************** Builder Implementation of FacilityExecutionExceptionDeclaration  ***********************/
	class FacilityExecutionExceptionDeclarationBuilderImpl implements FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder {
	
		protected List<String> reason = new ArrayList<>();
		protected List<OrganizationCharacteristic.OrganizationCharacteristicBuilder> organizationCharacteristic = new ArrayList<>();
		protected List<TransactionCharacteristic.TransactionCharacteristicBuilder> transactionCharacteristic = new ArrayList<>();
		protected List<SupervisorRegistration.SupervisorRegistrationBuilder> supervisorRegistration = new ArrayList<>();
	
		public FacilityExecutionExceptionDeclarationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("reason")
		public List<String> getReason() {
			return reason;
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
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addReason(String reason) {
			if (reason!=null) this.reason.add(reason);
			return this;
		}
		
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addReason(String reason, int _idx) {
			getIndex(this.reason, _idx, () -> reason);
			return this;
		}
		@Override 
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addReason(List<String> reasons) {
			if (reasons != null) {
				for (String toAdd : reasons) {
					this.reason.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("reason")
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder setReason(List<String> reasons) {
			if (reasons == null)  {
				this.reason = new ArrayList<>();
			}
			else {
				this.reason = reasons.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addOrganizationCharacteristic(OrganizationCharacteristic organizationCharacteristic) {
			if (organizationCharacteristic!=null) this.organizationCharacteristic.add(organizationCharacteristic.toBuilder());
			return this;
		}
		
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addOrganizationCharacteristic(OrganizationCharacteristic organizationCharacteristic, int _idx) {
			getIndex(this.organizationCharacteristic, _idx, () -> organizationCharacteristic.toBuilder());
			return this;
		}
		@Override 
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addOrganizationCharacteristic(List<? extends OrganizationCharacteristic> organizationCharacteristics) {
			if (organizationCharacteristics != null) {
				for (OrganizationCharacteristic toAdd : organizationCharacteristics) {
					this.organizationCharacteristic.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("organizationCharacteristic")
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder setOrganizationCharacteristic(List<? extends OrganizationCharacteristic> organizationCharacteristics) {
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
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addTransactionCharacteristic(TransactionCharacteristic transactionCharacteristic) {
			if (transactionCharacteristic!=null) this.transactionCharacteristic.add(transactionCharacteristic.toBuilder());
			return this;
		}
		
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addTransactionCharacteristic(TransactionCharacteristic transactionCharacteristic, int _idx) {
			getIndex(this.transactionCharacteristic, _idx, () -> transactionCharacteristic.toBuilder());
			return this;
		}
		@Override 
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addTransactionCharacteristic(List<? extends TransactionCharacteristic> transactionCharacteristics) {
			if (transactionCharacteristics != null) {
				for (TransactionCharacteristic toAdd : transactionCharacteristics) {
					this.transactionCharacteristic.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("transactionCharacteristic")
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder setTransactionCharacteristic(List<? extends TransactionCharacteristic> transactionCharacteristics) {
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
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addSupervisorRegistration(SupervisorRegistration supervisorRegistration) {
			if (supervisorRegistration!=null) this.supervisorRegistration.add(supervisorRegistration.toBuilder());
			return this;
		}
		
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addSupervisorRegistration(SupervisorRegistration supervisorRegistration, int _idx) {
			getIndex(this.supervisorRegistration, _idx, () -> supervisorRegistration.toBuilder());
			return this;
		}
		@Override 
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistrations) {
			if (supervisorRegistrations != null) {
				for (SupervisorRegistration toAdd : supervisorRegistrations) {
					this.supervisorRegistration.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("supervisorRegistration")
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder setSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistrations) {
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
		public FacilityExecutionExceptionDeclaration build() {
			return new FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationImpl(this);
		}
		
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder prune() {
			organizationCharacteristic = organizationCharacteristic.stream().filter(b->b!=null).<OrganizationCharacteristic.OrganizationCharacteristicBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			transactionCharacteristic = transactionCharacteristic.stream().filter(b->b!=null).<TransactionCharacteristic.TransactionCharacteristicBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			supervisorRegistration = supervisorRegistration.stream().filter(b->b!=null).<SupervisorRegistration.SupervisorRegistrationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReason()!=null && !getReason().isEmpty()) return true;
			if (getOrganizationCharacteristic()!=null && getOrganizationCharacteristic().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTransactionCharacteristic()!=null && getTransactionCharacteristic().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSupervisorRegistration()!=null && getSupervisorRegistration().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder o = (FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder) other;
			
			merger.mergeRosetta(getOrganizationCharacteristic(), o.getOrganizationCharacteristic(), this::getOrCreateOrganizationCharacteristic);
			merger.mergeRosetta(getTransactionCharacteristic(), o.getTransactionCharacteristic(), this::getOrCreateTransactionCharacteristic);
			merger.mergeRosetta(getSupervisorRegistration(), o.getSupervisorRegistration(), this::getOrCreateSupervisorRegistration);
			
			merger.mergeBasic(getReason(), o.getReason(), (Consumer<String>) this::addReason);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityExecutionExceptionDeclaration _that = getType().cast(o);
		
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			if (!ListEquals.listEquals(organizationCharacteristic, _that.getOrganizationCharacteristic())) return false;
			if (!ListEquals.listEquals(transactionCharacteristic, _that.getTransactionCharacteristic())) return false;
			if (!ListEquals.listEquals(supervisorRegistration, _that.getSupervisorRegistration())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			_result = 31 * _result + (organizationCharacteristic != null ? organizationCharacteristic.hashCode() : 0);
			_result = 31 * _result + (transactionCharacteristic != null ? transactionCharacteristic.hashCode() : 0);
			_result = 31 * _result + (supervisorRegistration != null ? supervisorRegistration.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityExecutionExceptionDeclarationBuilder {" +
				"reason=" + this.reason + ", " +
				"organizationCharacteristic=" + this.organizationCharacteristic + ", " +
				"transactionCharacteristic=" + this.transactionCharacteristic + ", " +
				"supervisorRegistration=" + this.supervisorRegistration +
			'}';
		}
	}
}
