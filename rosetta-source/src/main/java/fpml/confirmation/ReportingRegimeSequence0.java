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
import fpml.confirmation.ReportingRegimeName;
import fpml.confirmation.ReportingRegimeSequence0;
import fpml.confirmation.ReportingRegimeSequence0.ReportingRegimeSequence0Builder;
import fpml.confirmation.ReportingRegimeSequence0.ReportingRegimeSequence0BuilderImpl;
import fpml.confirmation.ReportingRegimeSequence0.ReportingRegimeSequence0Impl;
import fpml.confirmation.SupervisorRegistration;
import fpml.confirmation.meta.ReportingRegimeSequence0Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ReportingRegimeSequence0", builder=ReportingRegimeSequence0.ReportingRegimeSequence0BuilderImpl.class, version="${project.version}")
public interface ReportingRegimeSequence0 extends RosettaModelObject {

	ReportingRegimeSequence0Meta metaData = new ReportingRegimeSequence0Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identifies the reporting regime under which this data is reported. For example, Dodd-Frank, MiFID, HongKongOTCDRepository, ODRF
	 */
	ReportingRegimeName getName();
	/**
	 * Identifies the specific regulator or other supervisory body for which this data is produced. For example, CFTC, SEC, UKFSA, ODRF, SFC, ESMA.
	 */
	List<? extends SupervisorRegistration> getSupervisorRegistration();

	/*********************** Build Methods  ***********************/
	ReportingRegimeSequence0 build();
	
	ReportingRegimeSequence0.ReportingRegimeSequence0Builder toBuilder();
	
	static ReportingRegimeSequence0.ReportingRegimeSequence0Builder builder() {
		return new ReportingRegimeSequence0.ReportingRegimeSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportingRegimeSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReportingRegimeSequence0> getType() {
		return ReportingRegimeSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("name"), processor, ReportingRegimeName.class, getName());
		processRosetta(path.newSubPath("supervisorRegistration"), processor, SupervisorRegistration.class, getSupervisorRegistration());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportingRegimeSequence0Builder extends ReportingRegimeSequence0, RosettaModelObjectBuilder {
		ReportingRegimeName.ReportingRegimeNameBuilder getOrCreateName();
		ReportingRegimeName.ReportingRegimeNameBuilder getName();
		SupervisorRegistration.SupervisorRegistrationBuilder getOrCreateSupervisorRegistration(int _index);
		List<? extends SupervisorRegistration.SupervisorRegistrationBuilder> getSupervisorRegistration();
		ReportingRegimeSequence0.ReportingRegimeSequence0Builder setName(ReportingRegimeName name);
		ReportingRegimeSequence0.ReportingRegimeSequence0Builder addSupervisorRegistration(SupervisorRegistration supervisorRegistration0);
		ReportingRegimeSequence0.ReportingRegimeSequence0Builder addSupervisorRegistration(SupervisorRegistration supervisorRegistration1, int _idx);
		ReportingRegimeSequence0.ReportingRegimeSequence0Builder addSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistration2);
		ReportingRegimeSequence0.ReportingRegimeSequence0Builder setSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistration3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("name"), processor, ReportingRegimeName.ReportingRegimeNameBuilder.class, getName());
			processRosetta(path.newSubPath("supervisorRegistration"), processor, SupervisorRegistration.SupervisorRegistrationBuilder.class, getSupervisorRegistration());
		}
		

		ReportingRegimeSequence0.ReportingRegimeSequence0Builder prune();
	}

	/*********************** Immutable Implementation of ReportingRegimeSequence0  ***********************/
	class ReportingRegimeSequence0Impl implements ReportingRegimeSequence0 {
		private final ReportingRegimeName name;
		private final List<? extends SupervisorRegistration> supervisorRegistration;
		
		protected ReportingRegimeSequence0Impl(ReportingRegimeSequence0.ReportingRegimeSequence0Builder builder) {
			this.name = ofNullable(builder.getName()).map(f->f.build()).orElse(null);
			this.supervisorRegistration = ofNullable(builder.getSupervisorRegistration()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("name")
		public ReportingRegimeName getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("supervisorRegistration")
		public List<? extends SupervisorRegistration> getSupervisorRegistration() {
			return supervisorRegistration;
		}
		
		@Override
		public ReportingRegimeSequence0 build() {
			return this;
		}
		
		@Override
		public ReportingRegimeSequence0.ReportingRegimeSequence0Builder toBuilder() {
			ReportingRegimeSequence0.ReportingRegimeSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportingRegimeSequence0.ReportingRegimeSequence0Builder builder) {
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getSupervisorRegistration()).ifPresent(builder::setSupervisorRegistration);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingRegimeSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!ListEquals.listEquals(supervisorRegistration, _that.getSupervisorRegistration())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (supervisorRegistration != null ? supervisorRegistration.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingRegimeSequence0 {" +
				"name=" + this.name + ", " +
				"supervisorRegistration=" + this.supervisorRegistration +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportingRegimeSequence0  ***********************/
	class ReportingRegimeSequence0BuilderImpl implements ReportingRegimeSequence0.ReportingRegimeSequence0Builder {
	
		protected ReportingRegimeName.ReportingRegimeNameBuilder name;
		protected List<SupervisorRegistration.SupervisorRegistrationBuilder> supervisorRegistration = new ArrayList<>();
	
		public ReportingRegimeSequence0BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("name")
		public ReportingRegimeName.ReportingRegimeNameBuilder getName() {
			return name;
		}
		
		@Override
		public ReportingRegimeName.ReportingRegimeNameBuilder getOrCreateName() {
			ReportingRegimeName.ReportingRegimeNameBuilder result;
			if (name!=null) {
				result = name;
			}
			else {
				result = name = ReportingRegimeName.builder();
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
		@RosettaAttribute("name")
		public ReportingRegimeSequence0.ReportingRegimeSequence0Builder setName(ReportingRegimeName name) {
			this.name = name==null?null:name.toBuilder();
			return this;
		}
		@Override
		public ReportingRegimeSequence0.ReportingRegimeSequence0Builder addSupervisorRegistration(SupervisorRegistration supervisorRegistration) {
			if (supervisorRegistration!=null) this.supervisorRegistration.add(supervisorRegistration.toBuilder());
			return this;
		}
		
		@Override
		public ReportingRegimeSequence0.ReportingRegimeSequence0Builder addSupervisorRegistration(SupervisorRegistration supervisorRegistration, int _idx) {
			getIndex(this.supervisorRegistration, _idx, () -> supervisorRegistration.toBuilder());
			return this;
		}
		@Override 
		public ReportingRegimeSequence0.ReportingRegimeSequence0Builder addSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistrations) {
			if (supervisorRegistrations != null) {
				for (SupervisorRegistration toAdd : supervisorRegistrations) {
					this.supervisorRegistration.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("supervisorRegistration")
		public ReportingRegimeSequence0.ReportingRegimeSequence0Builder setSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistrations) {
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
		public ReportingRegimeSequence0 build() {
			return new ReportingRegimeSequence0.ReportingRegimeSequence0Impl(this);
		}
		
		@Override
		public ReportingRegimeSequence0.ReportingRegimeSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingRegimeSequence0.ReportingRegimeSequence0Builder prune() {
			if (name!=null && !name.prune().hasData()) name = null;
			supervisorRegistration = supervisorRegistration.stream().filter(b->b!=null).<SupervisorRegistration.SupervisorRegistrationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getName()!=null && getName().hasData()) return true;
			if (getSupervisorRegistration()!=null && getSupervisorRegistration().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingRegimeSequence0.ReportingRegimeSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportingRegimeSequence0.ReportingRegimeSequence0Builder o = (ReportingRegimeSequence0.ReportingRegimeSequence0Builder) other;
			
			merger.mergeRosetta(getName(), o.getName(), this::setName);
			merger.mergeRosetta(getSupervisorRegistration(), o.getSupervisorRegistration(), this::getOrCreateSupervisorRegistration);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingRegimeSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!ListEquals.listEquals(supervisorRegistration, _that.getSupervisorRegistration())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (supervisorRegistration != null ? supervisorRegistration.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingRegimeSequence0Builder {" +
				"name=" + this.name + ", " +
				"supervisorRegistration=" + this.supervisorRegistration +
			'}';
		}
	}
}
