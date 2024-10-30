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
import fpml.confirmation.RegulatorId;
import fpml.confirmation.SupervisorRegistrationModel;
import fpml.confirmation.SupervisorRegistrationModel.SupervisorRegistrationModelBuilder;
import fpml.confirmation.SupervisorRegistrationModel.SupervisorRegistrationModelBuilderImpl;
import fpml.confirmation.SupervisorRegistrationModel.SupervisorRegistrationModelImpl;
import fpml.confirmation.SupervisoryBody;
import fpml.confirmation.meta.SupervisorRegistrationModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides information about a regulator or other supervisory body that an organization is registered with.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="SupervisorRegistrationModel", builder=SupervisorRegistrationModel.SupervisorRegistrationModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface SupervisorRegistrationModel extends RosettaModelObject {

	SupervisorRegistrationModelMeta metaData = new SupervisorRegistrationModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The regulator or other supervisory body the organization is registered with (e.g. SEC).
	 */
	SupervisoryBody getSupervisoryBody();
	/**
	 * The ID assigned by the regulator (e.g. SEC&#39;s Central Index Key).
	 */
	RegulatorId getRegistrationNumber();

	/*********************** Build Methods  ***********************/
	SupervisorRegistrationModel build();
	
	SupervisorRegistrationModel.SupervisorRegistrationModelBuilder toBuilder();
	
	static SupervisorRegistrationModel.SupervisorRegistrationModelBuilder builder() {
		return new SupervisorRegistrationModel.SupervisorRegistrationModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SupervisorRegistrationModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SupervisorRegistrationModel> getType() {
		return SupervisorRegistrationModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("supervisoryBody"), processor, SupervisoryBody.class, getSupervisoryBody());
		processRosetta(path.newSubPath("registrationNumber"), processor, RegulatorId.class, getRegistrationNumber());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SupervisorRegistrationModelBuilder extends SupervisorRegistrationModel, RosettaModelObjectBuilder {
		SupervisoryBody.SupervisoryBodyBuilder getOrCreateSupervisoryBody();
		SupervisoryBody.SupervisoryBodyBuilder getSupervisoryBody();
		RegulatorId.RegulatorIdBuilder getOrCreateRegistrationNumber();
		RegulatorId.RegulatorIdBuilder getRegistrationNumber();
		SupervisorRegistrationModel.SupervisorRegistrationModelBuilder setSupervisoryBody(SupervisoryBody supervisoryBody);
		SupervisorRegistrationModel.SupervisorRegistrationModelBuilder setRegistrationNumber(RegulatorId registrationNumber);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("supervisoryBody"), processor, SupervisoryBody.SupervisoryBodyBuilder.class, getSupervisoryBody());
			processRosetta(path.newSubPath("registrationNumber"), processor, RegulatorId.RegulatorIdBuilder.class, getRegistrationNumber());
		}
		

		SupervisorRegistrationModel.SupervisorRegistrationModelBuilder prune();
	}

	/*********************** Immutable Implementation of SupervisorRegistrationModel  ***********************/
	class SupervisorRegistrationModelImpl implements SupervisorRegistrationModel {
		private final SupervisoryBody supervisoryBody;
		private final RegulatorId registrationNumber;
		
		protected SupervisorRegistrationModelImpl(SupervisorRegistrationModel.SupervisorRegistrationModelBuilder builder) {
			this.supervisoryBody = ofNullable(builder.getSupervisoryBody()).map(f->f.build()).orElse(null);
			this.registrationNumber = ofNullable(builder.getRegistrationNumber()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("supervisoryBody")
		public SupervisoryBody getSupervisoryBody() {
			return supervisoryBody;
		}
		
		@Override
		@RosettaAttribute("registrationNumber")
		public RegulatorId getRegistrationNumber() {
			return registrationNumber;
		}
		
		@Override
		public SupervisorRegistrationModel build() {
			return this;
		}
		
		@Override
		public SupervisorRegistrationModel.SupervisorRegistrationModelBuilder toBuilder() {
			SupervisorRegistrationModel.SupervisorRegistrationModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SupervisorRegistrationModel.SupervisorRegistrationModelBuilder builder) {
			ofNullable(getSupervisoryBody()).ifPresent(builder::setSupervisoryBody);
			ofNullable(getRegistrationNumber()).ifPresent(builder::setRegistrationNumber);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SupervisorRegistrationModel _that = getType().cast(o);
		
			if (!Objects.equals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(registrationNumber, _that.getRegistrationNumber())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (registrationNumber != null ? registrationNumber.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SupervisorRegistrationModel {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"registrationNumber=" + this.registrationNumber +
			'}';
		}
	}

	/*********************** Builder Implementation of SupervisorRegistrationModel  ***********************/
	class SupervisorRegistrationModelBuilderImpl implements SupervisorRegistrationModel.SupervisorRegistrationModelBuilder {
	
		protected SupervisoryBody.SupervisoryBodyBuilder supervisoryBody;
		protected RegulatorId.RegulatorIdBuilder registrationNumber;
	
		public SupervisorRegistrationModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("supervisoryBody")
		public SupervisoryBody.SupervisoryBodyBuilder getSupervisoryBody() {
			return supervisoryBody;
		}
		
		@Override
		public SupervisoryBody.SupervisoryBodyBuilder getOrCreateSupervisoryBody() {
			SupervisoryBody.SupervisoryBodyBuilder result;
			if (supervisoryBody!=null) {
				result = supervisoryBody;
			}
			else {
				result = supervisoryBody = SupervisoryBody.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("registrationNumber")
		public RegulatorId.RegulatorIdBuilder getRegistrationNumber() {
			return registrationNumber;
		}
		
		@Override
		public RegulatorId.RegulatorIdBuilder getOrCreateRegistrationNumber() {
			RegulatorId.RegulatorIdBuilder result;
			if (registrationNumber!=null) {
				result = registrationNumber;
			}
			else {
				result = registrationNumber = RegulatorId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("supervisoryBody")
		public SupervisorRegistrationModel.SupervisorRegistrationModelBuilder setSupervisoryBody(SupervisoryBody supervisoryBody) {
			this.supervisoryBody = supervisoryBody==null?null:supervisoryBody.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("registrationNumber")
		public SupervisorRegistrationModel.SupervisorRegistrationModelBuilder setRegistrationNumber(RegulatorId registrationNumber) {
			this.registrationNumber = registrationNumber==null?null:registrationNumber.toBuilder();
			return this;
		}
		
		@Override
		public SupervisorRegistrationModel build() {
			return new SupervisorRegistrationModel.SupervisorRegistrationModelImpl(this);
		}
		
		@Override
		public SupervisorRegistrationModel.SupervisorRegistrationModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SupervisorRegistrationModel.SupervisorRegistrationModelBuilder prune() {
			if (supervisoryBody!=null && !supervisoryBody.prune().hasData()) supervisoryBody = null;
			if (registrationNumber!=null && !registrationNumber.prune().hasData()) registrationNumber = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSupervisoryBody()!=null && getSupervisoryBody().hasData()) return true;
			if (getRegistrationNumber()!=null && getRegistrationNumber().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SupervisorRegistrationModel.SupervisorRegistrationModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SupervisorRegistrationModel.SupervisorRegistrationModelBuilder o = (SupervisorRegistrationModel.SupervisorRegistrationModelBuilder) other;
			
			merger.mergeRosetta(getSupervisoryBody(), o.getSupervisoryBody(), this::setSupervisoryBody);
			merger.mergeRosetta(getRegistrationNumber(), o.getRegistrationNumber(), this::setRegistrationNumber);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SupervisorRegistrationModel _that = getType().cast(o);
		
			if (!Objects.equals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(registrationNumber, _that.getRegistrationNumber())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (registrationNumber != null ? registrationNumber.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SupervisorRegistrationModelBuilder {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"registrationNumber=" + this.registrationNumber +
			'}';
		}
	}
}
