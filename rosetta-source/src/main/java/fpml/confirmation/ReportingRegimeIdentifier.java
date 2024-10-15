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
import fpml.confirmation.ActionType;
import fpml.confirmation.ReportingRegimeIdentifier;
import fpml.confirmation.ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder;
import fpml.confirmation.ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilderImpl;
import fpml.confirmation.ReportingRegimeIdentifier.ReportingRegimeIdentifierImpl;
import fpml.confirmation.ReportingRegimeIdentifierSequence;
import fpml.confirmation.ReportingRole;
import fpml.confirmation.SupervisorRegistration;
import fpml.confirmation.meta.ReportingRegimeIdentifierMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type that provides identification for reporting regimes.
 * @version ${project.version}
 */
@RosettaDataType(value="ReportingRegimeIdentifier", builder=ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilderImpl.class, version="${project.version}")
public interface ReportingRegimeIdentifier extends RosettaModelObject {

	ReportingRegimeIdentifierMeta metaData = new ReportingRegimeIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	ReportingRegimeIdentifierSequence getReportingRegimeIdentifierSequence();
	/**
	 * Identifies the specific regulator or other supervisory body for which this data is produced. For example, CFTC, SEC, UKFSA, ODRF, SFC, ESMA.
	 */
	List<? extends SupervisorRegistration> getSupervisorRegistration();
	/**
	 * Identifies the role of this party in reporting this trade for this regulator; roles could include ReportingParty and Voluntary reporting.
	 */
	ReportingRole getReportingRole();
	/**
	 * Reports a regulator-specific code for the action associated with this submission. Used, for example, to report the ESMA action type.
	 */
	ActionType getActionType();

	/*********************** Build Methods  ***********************/
	ReportingRegimeIdentifier build();
	
	ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder toBuilder();
	
	static ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder builder() {
		return new ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportingRegimeIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReportingRegimeIdentifier> getType() {
		return ReportingRegimeIdentifier.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("reportingRegimeIdentifierSequence"), processor, ReportingRegimeIdentifierSequence.class, getReportingRegimeIdentifierSequence());
		processRosetta(path.newSubPath("supervisorRegistration"), processor, SupervisorRegistration.class, getSupervisorRegistration());
		processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.class, getReportingRole());
		processRosetta(path.newSubPath("actionType"), processor, ActionType.class, getActionType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportingRegimeIdentifierBuilder extends ReportingRegimeIdentifier, RosettaModelObjectBuilder {
		ReportingRegimeIdentifierSequence.ReportingRegimeIdentifierSequenceBuilder getOrCreateReportingRegimeIdentifierSequence();
		ReportingRegimeIdentifierSequence.ReportingRegimeIdentifierSequenceBuilder getReportingRegimeIdentifierSequence();
		SupervisorRegistration.SupervisorRegistrationBuilder getOrCreateSupervisorRegistration(int _index);
		List<? extends SupervisorRegistration.SupervisorRegistrationBuilder> getSupervisorRegistration();
		ReportingRole.ReportingRoleBuilder getOrCreateReportingRole();
		ReportingRole.ReportingRoleBuilder getReportingRole();
		ActionType.ActionTypeBuilder getOrCreateActionType();
		ActionType.ActionTypeBuilder getActionType();
		ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder setReportingRegimeIdentifierSequence(ReportingRegimeIdentifierSequence reportingRegimeIdentifierSequence);
		ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder addSupervisorRegistration(SupervisorRegistration supervisorRegistration0);
		ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder addSupervisorRegistration(SupervisorRegistration supervisorRegistration1, int _idx);
		ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder addSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistration2);
		ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder setSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistration3);
		ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder setReportingRole(ReportingRole reportingRole);
		ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder setActionType(ActionType actionType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("reportingRegimeIdentifierSequence"), processor, ReportingRegimeIdentifierSequence.ReportingRegimeIdentifierSequenceBuilder.class, getReportingRegimeIdentifierSequence());
			processRosetta(path.newSubPath("supervisorRegistration"), processor, SupervisorRegistration.SupervisorRegistrationBuilder.class, getSupervisorRegistration());
			processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.ReportingRoleBuilder.class, getReportingRole());
			processRosetta(path.newSubPath("actionType"), processor, ActionType.ActionTypeBuilder.class, getActionType());
		}
		

		ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of ReportingRegimeIdentifier  ***********************/
	class ReportingRegimeIdentifierImpl implements ReportingRegimeIdentifier {
		private final ReportingRegimeIdentifierSequence reportingRegimeIdentifierSequence;
		private final List<? extends SupervisorRegistration> supervisorRegistration;
		private final ReportingRole reportingRole;
		private final ActionType actionType;
		
		protected ReportingRegimeIdentifierImpl(ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder builder) {
			this.reportingRegimeIdentifierSequence = ofNullable(builder.getReportingRegimeIdentifierSequence()).map(f->f.build()).orElse(null);
			this.supervisorRegistration = ofNullable(builder.getSupervisorRegistration()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.reportingRole = ofNullable(builder.getReportingRole()).map(f->f.build()).orElse(null);
			this.actionType = ofNullable(builder.getActionType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("reportingRegimeIdentifierSequence")
		public ReportingRegimeIdentifierSequence getReportingRegimeIdentifierSequence() {
			return reportingRegimeIdentifierSequence;
		}
		
		@Override
		@RosettaAttribute("supervisorRegistration")
		public List<? extends SupervisorRegistration> getSupervisorRegistration() {
			return supervisorRegistration;
		}
		
		@Override
		@RosettaAttribute("reportingRole")
		public ReportingRole getReportingRole() {
			return reportingRole;
		}
		
		@Override
		@RosettaAttribute("actionType")
		public ActionType getActionType() {
			return actionType;
		}
		
		@Override
		public ReportingRegimeIdentifier build() {
			return this;
		}
		
		@Override
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder toBuilder() {
			ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder builder) {
			ofNullable(getReportingRegimeIdentifierSequence()).ifPresent(builder::setReportingRegimeIdentifierSequence);
			ofNullable(getSupervisorRegistration()).ifPresent(builder::setSupervisorRegistration);
			ofNullable(getReportingRole()).ifPresent(builder::setReportingRole);
			ofNullable(getActionType()).ifPresent(builder::setActionType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingRegimeIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(reportingRegimeIdentifierSequence, _that.getReportingRegimeIdentifierSequence())) return false;
			if (!ListEquals.listEquals(supervisorRegistration, _that.getSupervisorRegistration())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reportingRegimeIdentifierSequence != null ? reportingRegimeIdentifierSequence.hashCode() : 0);
			_result = 31 * _result + (supervisorRegistration != null ? supervisorRegistration.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingRegimeIdentifier {" +
				"reportingRegimeIdentifierSequence=" + this.reportingRegimeIdentifierSequence + ", " +
				"supervisorRegistration=" + this.supervisorRegistration + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"actionType=" + this.actionType +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportingRegimeIdentifier  ***********************/
	class ReportingRegimeIdentifierBuilderImpl implements ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder {
	
		protected ReportingRegimeIdentifierSequence.ReportingRegimeIdentifierSequenceBuilder reportingRegimeIdentifierSequence;
		protected List<SupervisorRegistration.SupervisorRegistrationBuilder> supervisorRegistration = new ArrayList<>();
		protected ReportingRole.ReportingRoleBuilder reportingRole;
		protected ActionType.ActionTypeBuilder actionType;
	
		public ReportingRegimeIdentifierBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("reportingRegimeIdentifierSequence")
		public ReportingRegimeIdentifierSequence.ReportingRegimeIdentifierSequenceBuilder getReportingRegimeIdentifierSequence() {
			return reportingRegimeIdentifierSequence;
		}
		
		@Override
		public ReportingRegimeIdentifierSequence.ReportingRegimeIdentifierSequenceBuilder getOrCreateReportingRegimeIdentifierSequence() {
			ReportingRegimeIdentifierSequence.ReportingRegimeIdentifierSequenceBuilder result;
			if (reportingRegimeIdentifierSequence!=null) {
				result = reportingRegimeIdentifierSequence;
			}
			else {
				result = reportingRegimeIdentifierSequence = ReportingRegimeIdentifierSequence.builder();
			}
			
			return result;
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
		@RosettaAttribute("reportingRole")
		public ReportingRole.ReportingRoleBuilder getReportingRole() {
			return reportingRole;
		}
		
		@Override
		public ReportingRole.ReportingRoleBuilder getOrCreateReportingRole() {
			ReportingRole.ReportingRoleBuilder result;
			if (reportingRole!=null) {
				result = reportingRole;
			}
			else {
				result = reportingRole = ReportingRole.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("actionType")
		public ActionType.ActionTypeBuilder getActionType() {
			return actionType;
		}
		
		@Override
		public ActionType.ActionTypeBuilder getOrCreateActionType() {
			ActionType.ActionTypeBuilder result;
			if (actionType!=null) {
				result = actionType;
			}
			else {
				result = actionType = ActionType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportingRegimeIdentifierSequence")
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder setReportingRegimeIdentifierSequence(ReportingRegimeIdentifierSequence reportingRegimeIdentifierSequence) {
			this.reportingRegimeIdentifierSequence = reportingRegimeIdentifierSequence==null?null:reportingRegimeIdentifierSequence.toBuilder();
			return this;
		}
		@Override
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder addSupervisorRegistration(SupervisorRegistration supervisorRegistration) {
			if (supervisorRegistration!=null) this.supervisorRegistration.add(supervisorRegistration.toBuilder());
			return this;
		}
		
		@Override
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder addSupervisorRegistration(SupervisorRegistration supervisorRegistration, int _idx) {
			getIndex(this.supervisorRegistration, _idx, () -> supervisorRegistration.toBuilder());
			return this;
		}
		@Override 
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder addSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistrations) {
			if (supervisorRegistrations != null) {
				for (SupervisorRegistration toAdd : supervisorRegistrations) {
					this.supervisorRegistration.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("supervisorRegistration")
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder setSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistrations) {
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
		@RosettaAttribute("reportingRole")
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder setReportingRole(ReportingRole reportingRole) {
			this.reportingRole = reportingRole==null?null:reportingRole.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("actionType")
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder setActionType(ActionType actionType) {
			this.actionType = actionType==null?null:actionType.toBuilder();
			return this;
		}
		
		@Override
		public ReportingRegimeIdentifier build() {
			return new ReportingRegimeIdentifier.ReportingRegimeIdentifierImpl(this);
		}
		
		@Override
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder prune() {
			if (reportingRegimeIdentifierSequence!=null && !reportingRegimeIdentifierSequence.prune().hasData()) reportingRegimeIdentifierSequence = null;
			supervisorRegistration = supervisorRegistration.stream().filter(b->b!=null).<SupervisorRegistration.SupervisorRegistrationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (reportingRole!=null && !reportingRole.prune().hasData()) reportingRole = null;
			if (actionType!=null && !actionType.prune().hasData()) actionType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReportingRegimeIdentifierSequence()!=null && getReportingRegimeIdentifierSequence().hasData()) return true;
			if (getSupervisorRegistration()!=null && getSupervisorRegistration().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReportingRole()!=null && getReportingRole().hasData()) return true;
			if (getActionType()!=null && getActionType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder o = (ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder) other;
			
			merger.mergeRosetta(getReportingRegimeIdentifierSequence(), o.getReportingRegimeIdentifierSequence(), this::setReportingRegimeIdentifierSequence);
			merger.mergeRosetta(getSupervisorRegistration(), o.getSupervisorRegistration(), this::getOrCreateSupervisorRegistration);
			merger.mergeRosetta(getReportingRole(), o.getReportingRole(), this::setReportingRole);
			merger.mergeRosetta(getActionType(), o.getActionType(), this::setActionType);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingRegimeIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(reportingRegimeIdentifierSequence, _that.getReportingRegimeIdentifierSequence())) return false;
			if (!ListEquals.listEquals(supervisorRegistration, _that.getSupervisorRegistration())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reportingRegimeIdentifierSequence != null ? reportingRegimeIdentifierSequence.hashCode() : 0);
			_result = 31 * _result + (supervisorRegistration != null ? supervisorRegistration.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingRegimeIdentifierBuilder {" +
				"reportingRegimeIdentifierSequence=" + this.reportingRegimeIdentifierSequence + ", " +
				"supervisorRegistration=" + this.supervisorRegistration + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"actionType=" + this.actionType +
			'}';
		}
	}
}
