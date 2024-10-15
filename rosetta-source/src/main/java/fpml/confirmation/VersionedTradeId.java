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
import fpml.confirmation.TradeId;
import fpml.confirmation.VersionHistoryModel;
import fpml.confirmation.VersionedTradeId;
import fpml.confirmation.VersionedTradeId.VersionedTradeIdBuilder;
import fpml.confirmation.VersionedTradeId.VersionedTradeIdBuilderImpl;
import fpml.confirmation.VersionedTradeId.VersionedTradeIdImpl;
import fpml.confirmation.meta.VersionedTradeIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Trade Id with Version Support
 * @version ${project.version}
 */
@RosettaDataType(value="VersionedTradeId", builder=VersionedTradeId.VersionedTradeIdBuilderImpl.class, version="${project.version}")
public interface VersionedTradeId extends RosettaModelObject {

	VersionedTradeIdMeta metaData = new VersionedTradeIdMeta();

	/*********************** Getter Methods  ***********************/
	TradeId getTradeId();
	VersionHistoryModel getVersionHistoryModel();

	/*********************** Build Methods  ***********************/
	VersionedTradeId build();
	
	VersionedTradeId.VersionedTradeIdBuilder toBuilder();
	
	static VersionedTradeId.VersionedTradeIdBuilder builder() {
		return new VersionedTradeId.VersionedTradeIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VersionedTradeId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends VersionedTradeId> getType() {
		return VersionedTradeId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradeId"), processor, TradeId.class, getTradeId());
		processRosetta(path.newSubPath("versionHistoryModel"), processor, VersionHistoryModel.class, getVersionHistoryModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VersionedTradeIdBuilder extends VersionedTradeId, RosettaModelObjectBuilder {
		TradeId.TradeIdBuilder getOrCreateTradeId();
		TradeId.TradeIdBuilder getTradeId();
		VersionHistoryModel.VersionHistoryModelBuilder getOrCreateVersionHistoryModel();
		VersionHistoryModel.VersionHistoryModelBuilder getVersionHistoryModel();
		VersionedTradeId.VersionedTradeIdBuilder setTradeId(TradeId tradeId);
		VersionedTradeId.VersionedTradeIdBuilder setVersionHistoryModel(VersionHistoryModel versionHistoryModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradeId"), processor, TradeId.TradeIdBuilder.class, getTradeId());
			processRosetta(path.newSubPath("versionHistoryModel"), processor, VersionHistoryModel.VersionHistoryModelBuilder.class, getVersionHistoryModel());
		}
		

		VersionedTradeId.VersionedTradeIdBuilder prune();
	}

	/*********************** Immutable Implementation of VersionedTradeId  ***********************/
	class VersionedTradeIdImpl implements VersionedTradeId {
		private final TradeId tradeId;
		private final VersionHistoryModel versionHistoryModel;
		
		protected VersionedTradeIdImpl(VersionedTradeId.VersionedTradeIdBuilder builder) {
			this.tradeId = ofNullable(builder.getTradeId()).map(f->f.build()).orElse(null);
			this.versionHistoryModel = ofNullable(builder.getVersionHistoryModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeId")
		public TradeId getTradeId() {
			return tradeId;
		}
		
		@Override
		@RosettaAttribute("versionHistoryModel")
		public VersionHistoryModel getVersionHistoryModel() {
			return versionHistoryModel;
		}
		
		@Override
		public VersionedTradeId build() {
			return this;
		}
		
		@Override
		public VersionedTradeId.VersionedTradeIdBuilder toBuilder() {
			VersionedTradeId.VersionedTradeIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VersionedTradeId.VersionedTradeIdBuilder builder) {
			ofNullable(getTradeId()).ifPresent(builder::setTradeId);
			ofNullable(getVersionHistoryModel()).ifPresent(builder::setVersionHistoryModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VersionedTradeId _that = getType().cast(o);
		
			if (!Objects.equals(tradeId, _that.getTradeId())) return false;
			if (!Objects.equals(versionHistoryModel, _that.getVersionHistoryModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeId != null ? tradeId.hashCode() : 0);
			_result = 31 * _result + (versionHistoryModel != null ? versionHistoryModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VersionedTradeId {" +
				"tradeId=" + this.tradeId + ", " +
				"versionHistoryModel=" + this.versionHistoryModel +
			'}';
		}
	}

	/*********************** Builder Implementation of VersionedTradeId  ***********************/
	class VersionedTradeIdBuilderImpl implements VersionedTradeId.VersionedTradeIdBuilder {
	
		protected TradeId.TradeIdBuilder tradeId;
		protected VersionHistoryModel.VersionHistoryModelBuilder versionHistoryModel;
	
		public VersionedTradeIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradeId")
		public TradeId.TradeIdBuilder getTradeId() {
			return tradeId;
		}
		
		@Override
		public TradeId.TradeIdBuilder getOrCreateTradeId() {
			TradeId.TradeIdBuilder result;
			if (tradeId!=null) {
				result = tradeId;
			}
			else {
				result = tradeId = TradeId.builder();
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
		@RosettaAttribute("tradeId")
		public VersionedTradeId.VersionedTradeIdBuilder setTradeId(TradeId tradeId) {
			this.tradeId = tradeId==null?null:tradeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("versionHistoryModel")
		public VersionedTradeId.VersionedTradeIdBuilder setVersionHistoryModel(VersionHistoryModel versionHistoryModel) {
			this.versionHistoryModel = versionHistoryModel==null?null:versionHistoryModel.toBuilder();
			return this;
		}
		
		@Override
		public VersionedTradeId build() {
			return new VersionedTradeId.VersionedTradeIdImpl(this);
		}
		
		@Override
		public VersionedTradeId.VersionedTradeIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VersionedTradeId.VersionedTradeIdBuilder prune() {
			if (tradeId!=null && !tradeId.prune().hasData()) tradeId = null;
			if (versionHistoryModel!=null && !versionHistoryModel.prune().hasData()) versionHistoryModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradeId()!=null && getTradeId().hasData()) return true;
			if (getVersionHistoryModel()!=null && getVersionHistoryModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VersionedTradeId.VersionedTradeIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			VersionedTradeId.VersionedTradeIdBuilder o = (VersionedTradeId.VersionedTradeIdBuilder) other;
			
			merger.mergeRosetta(getTradeId(), o.getTradeId(), this::setTradeId);
			merger.mergeRosetta(getVersionHistoryModel(), o.getVersionHistoryModel(), this::setVersionHistoryModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VersionedTradeId _that = getType().cast(o);
		
			if (!Objects.equals(tradeId, _that.getTradeId())) return false;
			if (!Objects.equals(versionHistoryModel, _that.getVersionHistoryModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeId != null ? tradeId.hashCode() : 0);
			_result = 31 * _result + (versionHistoryModel != null ? versionHistoryModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VersionedTradeIdBuilder {" +
				"tradeId=" + this.tradeId + ", " +
				"versionHistoryModel=" + this.versionHistoryModel +
			'}';
		}
	}
}
