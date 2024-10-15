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
import fpml.confirmation.SupervisorRegistration;
import fpml.confirmation.SupervisorRegistration.SupervisorRegistrationBuilder;
import fpml.confirmation.SupervisorRegistration.SupervisorRegistrationBuilderImpl;
import fpml.confirmation.SupervisorRegistration.SupervisorRegistrationImpl;
import fpml.confirmation.SupervisorRegistrationModel;
import fpml.confirmation.meta.SupervisorRegistrationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides information about a regulator or other supervisory body that an organization is registered with.
 * @version ${project.version}
 */
@RosettaDataType(value="SupervisorRegistration", builder=SupervisorRegistration.SupervisorRegistrationBuilderImpl.class, version="${project.version}")
public interface SupervisorRegistration extends RosettaModelObject {

	SupervisorRegistrationMeta metaData = new SupervisorRegistrationMeta();

	/*********************** Getter Methods  ***********************/
	SupervisorRegistrationModel getSupervisorRegistrationModel();

	/*********************** Build Methods  ***********************/
	SupervisorRegistration build();
	
	SupervisorRegistration.SupervisorRegistrationBuilder toBuilder();
	
	static SupervisorRegistration.SupervisorRegistrationBuilder builder() {
		return new SupervisorRegistration.SupervisorRegistrationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SupervisorRegistration> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SupervisorRegistration> getType() {
		return SupervisorRegistration.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("supervisorRegistrationModel"), processor, SupervisorRegistrationModel.class, getSupervisorRegistrationModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SupervisorRegistrationBuilder extends SupervisorRegistration, RosettaModelObjectBuilder {
		SupervisorRegistrationModel.SupervisorRegistrationModelBuilder getOrCreateSupervisorRegistrationModel();
		SupervisorRegistrationModel.SupervisorRegistrationModelBuilder getSupervisorRegistrationModel();
		SupervisorRegistration.SupervisorRegistrationBuilder setSupervisorRegistrationModel(SupervisorRegistrationModel supervisorRegistrationModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("supervisorRegistrationModel"), processor, SupervisorRegistrationModel.SupervisorRegistrationModelBuilder.class, getSupervisorRegistrationModel());
		}
		

		SupervisorRegistration.SupervisorRegistrationBuilder prune();
	}

	/*********************** Immutable Implementation of SupervisorRegistration  ***********************/
	class SupervisorRegistrationImpl implements SupervisorRegistration {
		private final SupervisorRegistrationModel supervisorRegistrationModel;
		
		protected SupervisorRegistrationImpl(SupervisorRegistration.SupervisorRegistrationBuilder builder) {
			this.supervisorRegistrationModel = ofNullable(builder.getSupervisorRegistrationModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("supervisorRegistrationModel")
		public SupervisorRegistrationModel getSupervisorRegistrationModel() {
			return supervisorRegistrationModel;
		}
		
		@Override
		public SupervisorRegistration build() {
			return this;
		}
		
		@Override
		public SupervisorRegistration.SupervisorRegistrationBuilder toBuilder() {
			SupervisorRegistration.SupervisorRegistrationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SupervisorRegistration.SupervisorRegistrationBuilder builder) {
			ofNullable(getSupervisorRegistrationModel()).ifPresent(builder::setSupervisorRegistrationModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SupervisorRegistration _that = getType().cast(o);
		
			if (!Objects.equals(supervisorRegistrationModel, _that.getSupervisorRegistrationModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (supervisorRegistrationModel != null ? supervisorRegistrationModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SupervisorRegistration {" +
				"supervisorRegistrationModel=" + this.supervisorRegistrationModel +
			'}';
		}
	}

	/*********************** Builder Implementation of SupervisorRegistration  ***********************/
	class SupervisorRegistrationBuilderImpl implements SupervisorRegistration.SupervisorRegistrationBuilder {
	
		protected SupervisorRegistrationModel.SupervisorRegistrationModelBuilder supervisorRegistrationModel;
	
		public SupervisorRegistrationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("supervisorRegistrationModel")
		public SupervisorRegistrationModel.SupervisorRegistrationModelBuilder getSupervisorRegistrationModel() {
			return supervisorRegistrationModel;
		}
		
		@Override
		public SupervisorRegistrationModel.SupervisorRegistrationModelBuilder getOrCreateSupervisorRegistrationModel() {
			SupervisorRegistrationModel.SupervisorRegistrationModelBuilder result;
			if (supervisorRegistrationModel!=null) {
				result = supervisorRegistrationModel;
			}
			else {
				result = supervisorRegistrationModel = SupervisorRegistrationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("supervisorRegistrationModel")
		public SupervisorRegistration.SupervisorRegistrationBuilder setSupervisorRegistrationModel(SupervisorRegistrationModel supervisorRegistrationModel) {
			this.supervisorRegistrationModel = supervisorRegistrationModel==null?null:supervisorRegistrationModel.toBuilder();
			return this;
		}
		
		@Override
		public SupervisorRegistration build() {
			return new SupervisorRegistration.SupervisorRegistrationImpl(this);
		}
		
		@Override
		public SupervisorRegistration.SupervisorRegistrationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SupervisorRegistration.SupervisorRegistrationBuilder prune() {
			if (supervisorRegistrationModel!=null && !supervisorRegistrationModel.prune().hasData()) supervisorRegistrationModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSupervisorRegistrationModel()!=null && getSupervisorRegistrationModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SupervisorRegistration.SupervisorRegistrationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SupervisorRegistration.SupervisorRegistrationBuilder o = (SupervisorRegistration.SupervisorRegistrationBuilder) other;
			
			merger.mergeRosetta(getSupervisorRegistrationModel(), o.getSupervisorRegistrationModel(), this::setSupervisorRegistrationModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SupervisorRegistration _that = getType().cast(o);
		
			if (!Objects.equals(supervisorRegistrationModel, _that.getSupervisorRegistrationModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (supervisorRegistrationModel != null ? supervisorRegistrationModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SupervisorRegistrationBuilder {" +
				"supervisorRegistrationModel=" + this.supervisorRegistrationModel +
			'}';
		}
	}
}
