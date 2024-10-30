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
import fpml.confirmation.LegId;
import fpml.confirmation.LegIdentifier;
import fpml.confirmation.LegIdentifier.LegIdentifierBuilder;
import fpml.confirmation.LegIdentifier.LegIdentifierBuilderImpl;
import fpml.confirmation.LegIdentifier.LegIdentifierImpl;
import fpml.confirmation.VersionHistoryModel;
import fpml.confirmation.meta.LegIdentifierMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Version aware identification of a leg.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LegIdentifier", builder=LegIdentifier.LegIdentifierBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LegIdentifier extends RosettaModelObject {

	LegIdentifierMeta metaData = new LegIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identity of this leg.
	 */
	LegId getLegId();
	VersionHistoryModel getVersionHistoryModel();

	/*********************** Build Methods  ***********************/
	LegIdentifier build();
	
	LegIdentifier.LegIdentifierBuilder toBuilder();
	
	static LegIdentifier.LegIdentifierBuilder builder() {
		return new LegIdentifier.LegIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LegIdentifier> getType() {
		return LegIdentifier.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("legId"), processor, LegId.class, getLegId());
		processRosetta(path.newSubPath("versionHistoryModel"), processor, VersionHistoryModel.class, getVersionHistoryModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegIdentifierBuilder extends LegIdentifier, RosettaModelObjectBuilder {
		LegId.LegIdBuilder getOrCreateLegId();
		LegId.LegIdBuilder getLegId();
		VersionHistoryModel.VersionHistoryModelBuilder getOrCreateVersionHistoryModel();
		VersionHistoryModel.VersionHistoryModelBuilder getVersionHistoryModel();
		LegIdentifier.LegIdentifierBuilder setLegId(LegId legId);
		LegIdentifier.LegIdentifierBuilder setVersionHistoryModel(VersionHistoryModel versionHistoryModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("legId"), processor, LegId.LegIdBuilder.class, getLegId());
			processRosetta(path.newSubPath("versionHistoryModel"), processor, VersionHistoryModel.VersionHistoryModelBuilder.class, getVersionHistoryModel());
		}
		

		LegIdentifier.LegIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of LegIdentifier  ***********************/
	class LegIdentifierImpl implements LegIdentifier {
		private final LegId legId;
		private final VersionHistoryModel versionHistoryModel;
		
		protected LegIdentifierImpl(LegIdentifier.LegIdentifierBuilder builder) {
			this.legId = ofNullable(builder.getLegId()).map(f->f.build()).orElse(null);
			this.versionHistoryModel = ofNullable(builder.getVersionHistoryModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("legId")
		public LegId getLegId() {
			return legId;
		}
		
		@Override
		@RosettaAttribute("versionHistoryModel")
		public VersionHistoryModel getVersionHistoryModel() {
			return versionHistoryModel;
		}
		
		@Override
		public LegIdentifier build() {
			return this;
		}
		
		@Override
		public LegIdentifier.LegIdentifierBuilder toBuilder() {
			LegIdentifier.LegIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegIdentifier.LegIdentifierBuilder builder) {
			ofNullable(getLegId()).ifPresent(builder::setLegId);
			ofNullable(getVersionHistoryModel()).ifPresent(builder::setVersionHistoryModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(legId, _that.getLegId())) return false;
			if (!Objects.equals(versionHistoryModel, _that.getVersionHistoryModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (legId != null ? legId.hashCode() : 0);
			_result = 31 * _result + (versionHistoryModel != null ? versionHistoryModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegIdentifier {" +
				"legId=" + this.legId + ", " +
				"versionHistoryModel=" + this.versionHistoryModel +
			'}';
		}
	}

	/*********************** Builder Implementation of LegIdentifier  ***********************/
	class LegIdentifierBuilderImpl implements LegIdentifier.LegIdentifierBuilder {
	
		protected LegId.LegIdBuilder legId;
		protected VersionHistoryModel.VersionHistoryModelBuilder versionHistoryModel;
	
		public LegIdentifierBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("legId")
		public LegId.LegIdBuilder getLegId() {
			return legId;
		}
		
		@Override
		public LegId.LegIdBuilder getOrCreateLegId() {
			LegId.LegIdBuilder result;
			if (legId!=null) {
				result = legId;
			}
			else {
				result = legId = LegId.builder();
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
		@RosettaAttribute("legId")
		public LegIdentifier.LegIdentifierBuilder setLegId(LegId legId) {
			this.legId = legId==null?null:legId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("versionHistoryModel")
		public LegIdentifier.LegIdentifierBuilder setVersionHistoryModel(VersionHistoryModel versionHistoryModel) {
			this.versionHistoryModel = versionHistoryModel==null?null:versionHistoryModel.toBuilder();
			return this;
		}
		
		@Override
		public LegIdentifier build() {
			return new LegIdentifier.LegIdentifierImpl(this);
		}
		
		@Override
		public LegIdentifier.LegIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegIdentifier.LegIdentifierBuilder prune() {
			if (legId!=null && !legId.prune().hasData()) legId = null;
			if (versionHistoryModel!=null && !versionHistoryModel.prune().hasData()) versionHistoryModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLegId()!=null && getLegId().hasData()) return true;
			if (getVersionHistoryModel()!=null && getVersionHistoryModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegIdentifier.LegIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegIdentifier.LegIdentifierBuilder o = (LegIdentifier.LegIdentifierBuilder) other;
			
			merger.mergeRosetta(getLegId(), o.getLegId(), this::setLegId);
			merger.mergeRosetta(getVersionHistoryModel(), o.getVersionHistoryModel(), this::setVersionHistoryModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(legId, _that.getLegId())) return false;
			if (!Objects.equals(versionHistoryModel, _that.getVersionHistoryModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (legId != null ? legId.hashCode() : 0);
			_result = 31 * _result + (versionHistoryModel != null ? versionHistoryModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegIdentifierBuilder {" +
				"legId=" + this.legId + ", " +
				"versionHistoryModel=" + this.versionHistoryModel +
			'}';
		}
	}
}
