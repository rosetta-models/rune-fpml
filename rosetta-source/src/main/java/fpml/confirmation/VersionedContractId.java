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
import fpml.confirmation.ContractId;
import fpml.confirmation.VersionHistoryModel;
import fpml.confirmation.VersionedContractId;
import fpml.confirmation.VersionedContractId.VersionedContractIdBuilder;
import fpml.confirmation.VersionedContractId.VersionedContractIdBuilderImpl;
import fpml.confirmation.VersionedContractId.VersionedContractIdImpl;
import fpml.confirmation.meta.VersionedContractIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Contract Id with Version Support
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="VersionedContractId", builder=VersionedContractId.VersionedContractIdBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface VersionedContractId extends RosettaModelObject {

	VersionedContractIdMeta metaData = new VersionedContractIdMeta();

	/*********************** Getter Methods  ***********************/
	ContractId getContractId();
	VersionHistoryModel getVersionHistoryModel();

	/*********************** Build Methods  ***********************/
	VersionedContractId build();
	
	VersionedContractId.VersionedContractIdBuilder toBuilder();
	
	static VersionedContractId.VersionedContractIdBuilder builder() {
		return new VersionedContractId.VersionedContractIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VersionedContractId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends VersionedContractId> getType() {
		return VersionedContractId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("contractId"), processor, ContractId.class, getContractId());
		processRosetta(path.newSubPath("versionHistoryModel"), processor, VersionHistoryModel.class, getVersionHistoryModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VersionedContractIdBuilder extends VersionedContractId, RosettaModelObjectBuilder {
		ContractId.ContractIdBuilder getOrCreateContractId();
		ContractId.ContractIdBuilder getContractId();
		VersionHistoryModel.VersionHistoryModelBuilder getOrCreateVersionHistoryModel();
		VersionHistoryModel.VersionHistoryModelBuilder getVersionHistoryModel();
		VersionedContractId.VersionedContractIdBuilder setContractId(ContractId contractId);
		VersionedContractId.VersionedContractIdBuilder setVersionHistoryModel(VersionHistoryModel versionHistoryModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("contractId"), processor, ContractId.ContractIdBuilder.class, getContractId());
			processRosetta(path.newSubPath("versionHistoryModel"), processor, VersionHistoryModel.VersionHistoryModelBuilder.class, getVersionHistoryModel());
		}
		

		VersionedContractId.VersionedContractIdBuilder prune();
	}

	/*********************** Immutable Implementation of VersionedContractId  ***********************/
	class VersionedContractIdImpl implements VersionedContractId {
		private final ContractId contractId;
		private final VersionHistoryModel versionHistoryModel;
		
		protected VersionedContractIdImpl(VersionedContractId.VersionedContractIdBuilder builder) {
			this.contractId = ofNullable(builder.getContractId()).map(f->f.build()).orElse(null);
			this.versionHistoryModel = ofNullable(builder.getVersionHistoryModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("contractId")
		public ContractId getContractId() {
			return contractId;
		}
		
		@Override
		@RosettaAttribute("versionHistoryModel")
		public VersionHistoryModel getVersionHistoryModel() {
			return versionHistoryModel;
		}
		
		@Override
		public VersionedContractId build() {
			return this;
		}
		
		@Override
		public VersionedContractId.VersionedContractIdBuilder toBuilder() {
			VersionedContractId.VersionedContractIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VersionedContractId.VersionedContractIdBuilder builder) {
			ofNullable(getContractId()).ifPresent(builder::setContractId);
			ofNullable(getVersionHistoryModel()).ifPresent(builder::setVersionHistoryModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VersionedContractId _that = getType().cast(o);
		
			if (!Objects.equals(contractId, _that.getContractId())) return false;
			if (!Objects.equals(versionHistoryModel, _that.getVersionHistoryModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contractId != null ? contractId.hashCode() : 0);
			_result = 31 * _result + (versionHistoryModel != null ? versionHistoryModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VersionedContractId {" +
				"contractId=" + this.contractId + ", " +
				"versionHistoryModel=" + this.versionHistoryModel +
			'}';
		}
	}

	/*********************** Builder Implementation of VersionedContractId  ***********************/
	class VersionedContractIdBuilderImpl implements VersionedContractId.VersionedContractIdBuilder {
	
		protected ContractId.ContractIdBuilder contractId;
		protected VersionHistoryModel.VersionHistoryModelBuilder versionHistoryModel;
	
		public VersionedContractIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("contractId")
		public ContractId.ContractIdBuilder getContractId() {
			return contractId;
		}
		
		@Override
		public ContractId.ContractIdBuilder getOrCreateContractId() {
			ContractId.ContractIdBuilder result;
			if (contractId!=null) {
				result = contractId;
			}
			else {
				result = contractId = ContractId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("versionHistoryModel")
		public VersionHistoryModel.VersionHistoryModelBuilder getVersionHistoryModel() {
			return versionHistoryModel;
		}
		
		@Override
		public VersionHistoryModel.VersionHistoryModelBuilder getOrCreateVersionHistoryModel() {
			VersionHistoryModel.VersionHistoryModelBuilder result;
			if (versionHistoryModel!=null) {
				result = versionHistoryModel;
			}
			else {
				result = versionHistoryModel = VersionHistoryModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("contractId")
		public VersionedContractId.VersionedContractIdBuilder setContractId(ContractId contractId) {
			this.contractId = contractId==null?null:contractId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("versionHistoryModel")
		public VersionedContractId.VersionedContractIdBuilder setVersionHistoryModel(VersionHistoryModel versionHistoryModel) {
			this.versionHistoryModel = versionHistoryModel==null?null:versionHistoryModel.toBuilder();
			return this;
		}
		
		@Override
		public VersionedContractId build() {
			return new VersionedContractId.VersionedContractIdImpl(this);
		}
		
		@Override
		public VersionedContractId.VersionedContractIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VersionedContractId.VersionedContractIdBuilder prune() {
			if (contractId!=null && !contractId.prune().hasData()) contractId = null;
			if (versionHistoryModel!=null && !versionHistoryModel.prune().hasData()) versionHistoryModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getContractId()!=null && getContractId().hasData()) return true;
			if (getVersionHistoryModel()!=null && getVersionHistoryModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VersionedContractId.VersionedContractIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			VersionedContractId.VersionedContractIdBuilder o = (VersionedContractId.VersionedContractIdBuilder) other;
			
			merger.mergeRosetta(getContractId(), o.getContractId(), this::setContractId);
			merger.mergeRosetta(getVersionHistoryModel(), o.getVersionHistoryModel(), this::setVersionHistoryModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VersionedContractId _that = getType().cast(o);
		
			if (!Objects.equals(contractId, _that.getContractId())) return false;
			if (!Objects.equals(versionHistoryModel, _that.getVersionHistoryModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contractId != null ? contractId.hashCode() : 0);
			_result = 31 * _result + (versionHistoryModel != null ? versionHistoryModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VersionedContractIdBuilder {" +
				"contractId=" + this.contractId + ", " +
				"versionHistoryModel=" + this.versionHistoryModel +
			'}';
		}
	}
}
