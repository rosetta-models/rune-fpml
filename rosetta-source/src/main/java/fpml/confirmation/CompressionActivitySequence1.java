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
import fpml.confirmation.CompressionActivitySequence1;
import fpml.confirmation.CompressionActivitySequence1.CompressionActivitySequence1Builder;
import fpml.confirmation.CompressionActivitySequence1.CompressionActivitySequence1BuilderImpl;
import fpml.confirmation.CompressionActivitySequence1.CompressionActivitySequence1Impl;
import fpml.confirmation.TradeId;
import fpml.confirmation.meta.CompressionActivitySequence1Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CompressionActivitySequence1", builder=CompressionActivitySequence1.CompressionActivitySequence1BuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CompressionActivitySequence1 extends RosettaModelObject {

	CompressionActivitySequence1Meta metaData = new CompressionActivitySequence1Meta();

	/*********************** Getter Methods  ***********************/
	TradeId getReplacementTradeId();
	List<? extends TradeId> getOriginatingTradeId();

	/*********************** Build Methods  ***********************/
	CompressionActivitySequence1 build();
	
	CompressionActivitySequence1.CompressionActivitySequence1Builder toBuilder();
	
	static CompressionActivitySequence1.CompressionActivitySequence1Builder builder() {
		return new CompressionActivitySequence1.CompressionActivitySequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CompressionActivitySequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CompressionActivitySequence1> getType() {
		return CompressionActivitySequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("replacementTradeId"), processor, TradeId.class, getReplacementTradeId());
		processRosetta(path.newSubPath("originatingTradeId"), processor, TradeId.class, getOriginatingTradeId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CompressionActivitySequence1Builder extends CompressionActivitySequence1, RosettaModelObjectBuilder {
		TradeId.TradeIdBuilder getOrCreateReplacementTradeId();
		TradeId.TradeIdBuilder getReplacementTradeId();
		TradeId.TradeIdBuilder getOrCreateOriginatingTradeId(int _index);
		List<? extends TradeId.TradeIdBuilder> getOriginatingTradeId();
		CompressionActivitySequence1.CompressionActivitySequence1Builder setReplacementTradeId(TradeId replacementTradeId);
		CompressionActivitySequence1.CompressionActivitySequence1Builder addOriginatingTradeId(TradeId originatingTradeId0);
		CompressionActivitySequence1.CompressionActivitySequence1Builder addOriginatingTradeId(TradeId originatingTradeId1, int _idx);
		CompressionActivitySequence1.CompressionActivitySequence1Builder addOriginatingTradeId(List<? extends TradeId> originatingTradeId2);
		CompressionActivitySequence1.CompressionActivitySequence1Builder setOriginatingTradeId(List<? extends TradeId> originatingTradeId3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("replacementTradeId"), processor, TradeId.TradeIdBuilder.class, getReplacementTradeId());
			processRosetta(path.newSubPath("originatingTradeId"), processor, TradeId.TradeIdBuilder.class, getOriginatingTradeId());
		}
		

		CompressionActivitySequence1.CompressionActivitySequence1Builder prune();
	}

	/*********************** Immutable Implementation of CompressionActivitySequence1  ***********************/
	class CompressionActivitySequence1Impl implements CompressionActivitySequence1 {
		private final TradeId replacementTradeId;
		private final List<? extends TradeId> originatingTradeId;
		
		protected CompressionActivitySequence1Impl(CompressionActivitySequence1.CompressionActivitySequence1Builder builder) {
			this.replacementTradeId = ofNullable(builder.getReplacementTradeId()).map(f->f.build()).orElse(null);
			this.originatingTradeId = ofNullable(builder.getOriginatingTradeId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("replacementTradeId")
		public TradeId getReplacementTradeId() {
			return replacementTradeId;
		}
		
		@Override
		@RosettaAttribute("originatingTradeId")
		public List<? extends TradeId> getOriginatingTradeId() {
			return originatingTradeId;
		}
		
		@Override
		public CompressionActivitySequence1 build() {
			return this;
		}
		
		@Override
		public CompressionActivitySequence1.CompressionActivitySequence1Builder toBuilder() {
			CompressionActivitySequence1.CompressionActivitySequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CompressionActivitySequence1.CompressionActivitySequence1Builder builder) {
			ofNullable(getReplacementTradeId()).ifPresent(builder::setReplacementTradeId);
			ofNullable(getOriginatingTradeId()).ifPresent(builder::setOriginatingTradeId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CompressionActivitySequence1 _that = getType().cast(o);
		
			if (!Objects.equals(replacementTradeId, _that.getReplacementTradeId())) return false;
			if (!ListEquals.listEquals(originatingTradeId, _that.getOriginatingTradeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (replacementTradeId != null ? replacementTradeId.hashCode() : 0);
			_result = 31 * _result + (originatingTradeId != null ? originatingTradeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CompressionActivitySequence1 {" +
				"replacementTradeId=" + this.replacementTradeId + ", " +
				"originatingTradeId=" + this.originatingTradeId +
			'}';
		}
	}

	/*********************** Builder Implementation of CompressionActivitySequence1  ***********************/
	class CompressionActivitySequence1BuilderImpl implements CompressionActivitySequence1.CompressionActivitySequence1Builder {
	
		protected TradeId.TradeIdBuilder replacementTradeId;
		protected List<TradeId.TradeIdBuilder> originatingTradeId = new ArrayList<>();
	
		public CompressionActivitySequence1BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("replacementTradeId")
		public TradeId.TradeIdBuilder getReplacementTradeId() {
			return replacementTradeId;
		}
		
		@Override
		public TradeId.TradeIdBuilder getOrCreateReplacementTradeId() {
			TradeId.TradeIdBuilder result;
			if (replacementTradeId!=null) {
				result = replacementTradeId;
			}
			else {
				result = replacementTradeId = TradeId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("originatingTradeId")
		public List<? extends TradeId.TradeIdBuilder> getOriginatingTradeId() {
			return originatingTradeId;
		}
		
		@Override
		public TradeId.TradeIdBuilder getOrCreateOriginatingTradeId(int _index) {
		
			if (originatingTradeId==null) {
				this.originatingTradeId = new ArrayList<>();
			}
			TradeId.TradeIdBuilder result;
			return getIndex(originatingTradeId, _index, () -> {
						TradeId.TradeIdBuilder newOriginatingTradeId = TradeId.builder();
						return newOriginatingTradeId;
					});
		}
		
		@Override
		@RosettaAttribute("replacementTradeId")
		public CompressionActivitySequence1.CompressionActivitySequence1Builder setReplacementTradeId(TradeId replacementTradeId) {
			this.replacementTradeId = replacementTradeId==null?null:replacementTradeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("originatingTradeId")
		public CompressionActivitySequence1.CompressionActivitySequence1Builder addOriginatingTradeId(TradeId originatingTradeId) {
			if (originatingTradeId!=null) this.originatingTradeId.add(originatingTradeId.toBuilder());
			return this;
		}
		
		@Override
		public CompressionActivitySequence1.CompressionActivitySequence1Builder addOriginatingTradeId(TradeId originatingTradeId, int _idx) {
			getIndex(this.originatingTradeId, _idx, () -> originatingTradeId.toBuilder());
			return this;
		}
		@Override 
		public CompressionActivitySequence1.CompressionActivitySequence1Builder addOriginatingTradeId(List<? extends TradeId> originatingTradeIds) {
			if (originatingTradeIds != null) {
				for (TradeId toAdd : originatingTradeIds) {
					this.originatingTradeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CompressionActivitySequence1.CompressionActivitySequence1Builder setOriginatingTradeId(List<? extends TradeId> originatingTradeIds) {
			if (originatingTradeIds == null)  {
				this.originatingTradeId = new ArrayList<>();
			}
			else {
				this.originatingTradeId = originatingTradeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public CompressionActivitySequence1 build() {
			return new CompressionActivitySequence1.CompressionActivitySequence1Impl(this);
		}
		
		@Override
		public CompressionActivitySequence1.CompressionActivitySequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CompressionActivitySequence1.CompressionActivitySequence1Builder prune() {
			if (replacementTradeId!=null && !replacementTradeId.prune().hasData()) replacementTradeId = null;
			originatingTradeId = originatingTradeId.stream().filter(b->b!=null).<TradeId.TradeIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReplacementTradeId()!=null && getReplacementTradeId().hasData()) return true;
			if (getOriginatingTradeId()!=null && getOriginatingTradeId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CompressionActivitySequence1.CompressionActivitySequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CompressionActivitySequence1.CompressionActivitySequence1Builder o = (CompressionActivitySequence1.CompressionActivitySequence1Builder) other;
			
			merger.mergeRosetta(getReplacementTradeId(), o.getReplacementTradeId(), this::setReplacementTradeId);
			merger.mergeRosetta(getOriginatingTradeId(), o.getOriginatingTradeId(), this::getOrCreateOriginatingTradeId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CompressionActivitySequence1 _that = getType().cast(o);
		
			if (!Objects.equals(replacementTradeId, _that.getReplacementTradeId())) return false;
			if (!ListEquals.listEquals(originatingTradeId, _that.getOriginatingTradeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (replacementTradeId != null ? replacementTradeId.hashCode() : 0);
			_result = 31 * _result + (originatingTradeId != null ? originatingTradeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CompressionActivitySequence1Builder {" +
				"replacementTradeId=" + this.replacementTradeId + ", " +
				"originatingTradeId=" + this.originatingTradeId +
			'}';
		}
	}
}
