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
import fpml.confirmation.TradeIdentifierSequenceChoice;
import fpml.confirmation.TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder;
import fpml.confirmation.TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilderImpl;
import fpml.confirmation.TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceImpl;
import fpml.confirmation.VersionedTradeId;
import fpml.confirmation.meta.TradeIdentifierSequenceChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradeIdentifierSequenceChoice", builder=TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilderImpl.class, version="${project.version}")
public interface TradeIdentifierSequenceChoice extends RosettaModelObject {

	TradeIdentifierSequenceChoiceMeta metaData = new TradeIdentifierSequenceChoiceMeta();

	/*********************** Getter Methods  ***********************/
	TradeId getTradeId();
	/**
	 * A trade identifier accompanied by a version number. In regulatory reporting views, this should be avoided except for internal mnessaging.
	 */
	VersionedTradeId getVersionedTradeId();

	/*********************** Build Methods  ***********************/
	TradeIdentifierSequenceChoice build();
	
	TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder toBuilder();
	
	static TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder builder() {
		return new TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeIdentifierSequenceChoice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeIdentifierSequenceChoice> getType() {
		return TradeIdentifierSequenceChoice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradeId"), processor, TradeId.class, getTradeId());
		processRosetta(path.newSubPath("versionedTradeId"), processor, VersionedTradeId.class, getVersionedTradeId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeIdentifierSequenceChoiceBuilder extends TradeIdentifierSequenceChoice, RosettaModelObjectBuilder {
		TradeId.TradeIdBuilder getOrCreateTradeId();
		TradeId.TradeIdBuilder getTradeId();
		VersionedTradeId.VersionedTradeIdBuilder getOrCreateVersionedTradeId();
		VersionedTradeId.VersionedTradeIdBuilder getVersionedTradeId();
		TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder setTradeId(TradeId tradeId);
		TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder setVersionedTradeId(VersionedTradeId versionedTradeId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradeId"), processor, TradeId.TradeIdBuilder.class, getTradeId());
			processRosetta(path.newSubPath("versionedTradeId"), processor, VersionedTradeId.VersionedTradeIdBuilder.class, getVersionedTradeId());
		}
		

		TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of TradeIdentifierSequenceChoice  ***********************/
	class TradeIdentifierSequenceChoiceImpl implements TradeIdentifierSequenceChoice {
		private final TradeId tradeId;
		private final VersionedTradeId versionedTradeId;
		
		protected TradeIdentifierSequenceChoiceImpl(TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder builder) {
			this.tradeId = ofNullable(builder.getTradeId()).map(f->f.build()).orElse(null);
			this.versionedTradeId = ofNullable(builder.getVersionedTradeId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeId")
		public TradeId getTradeId() {
			return tradeId;
		}
		
		@Override
		@RosettaAttribute("versionedTradeId")
		public VersionedTradeId getVersionedTradeId() {
			return versionedTradeId;
		}
		
		@Override
		public TradeIdentifierSequenceChoice build() {
			return this;
		}
		
		@Override
		public TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder toBuilder() {
			TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder builder) {
			ofNullable(getTradeId()).ifPresent(builder::setTradeId);
			ofNullable(getVersionedTradeId()).ifPresent(builder::setVersionedTradeId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeIdentifierSequenceChoice _that = getType().cast(o);
		
			if (!Objects.equals(tradeId, _that.getTradeId())) return false;
			if (!Objects.equals(versionedTradeId, _that.getVersionedTradeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeId != null ? tradeId.hashCode() : 0);
			_result = 31 * _result + (versionedTradeId != null ? versionedTradeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeIdentifierSequenceChoice {" +
				"tradeId=" + this.tradeId + ", " +
				"versionedTradeId=" + this.versionedTradeId +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeIdentifierSequenceChoice  ***********************/
	class TradeIdentifierSequenceChoiceBuilderImpl implements TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder {
	
		protected TradeId.TradeIdBuilder tradeId;
		protected VersionedTradeId.VersionedTradeIdBuilder versionedTradeId;
	
		public TradeIdentifierSequenceChoiceBuilderImpl() {
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
		@RosettaAttribute("versionedTradeId")
		public VersionedTradeId.VersionedTradeIdBuilder getVersionedTradeId() {
			return versionedTradeId;
		}
		
		@Override
		public VersionedTradeId.VersionedTradeIdBuilder getOrCreateVersionedTradeId() {
			VersionedTradeId.VersionedTradeIdBuilder result;
			if (versionedTradeId!=null) {
				result = versionedTradeId;
			}
			else {
				result = versionedTradeId = VersionedTradeId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeId")
		public TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder setTradeId(TradeId tradeId) {
			this.tradeId = tradeId==null?null:tradeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("versionedTradeId")
		public TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder setVersionedTradeId(VersionedTradeId versionedTradeId) {
			this.versionedTradeId = versionedTradeId==null?null:versionedTradeId.toBuilder();
			return this;
		}
		
		@Override
		public TradeIdentifierSequenceChoice build() {
			return new TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceImpl(this);
		}
		
		@Override
		public TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder prune() {
			if (tradeId!=null && !tradeId.prune().hasData()) tradeId = null;
			if (versionedTradeId!=null && !versionedTradeId.prune().hasData()) versionedTradeId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradeId()!=null && getTradeId().hasData()) return true;
			if (getVersionedTradeId()!=null && getVersionedTradeId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder o = (TradeIdentifierSequenceChoice.TradeIdentifierSequenceChoiceBuilder) other;
			
			merger.mergeRosetta(getTradeId(), o.getTradeId(), this::setTradeId);
			merger.mergeRosetta(getVersionedTradeId(), o.getVersionedTradeId(), this::setVersionedTradeId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeIdentifierSequenceChoice _that = getType().cast(o);
		
			if (!Objects.equals(tradeId, _that.getTradeId())) return false;
			if (!Objects.equals(versionedTradeId, _that.getVersionedTradeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeId != null ? tradeId.hashCode() : 0);
			_result = 31 * _result + (versionedTradeId != null ? versionedTradeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeIdentifierSequenceChoiceBuilder {" +
				"tradeId=" + this.tradeId + ", " +
				"versionedTradeId=" + this.versionedTradeId +
			'}';
		}
	}
}
