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
import fpml.confirmation.CompressionActivitySequence0;
import fpml.confirmation.CompressionActivitySequence0.CompressionActivitySequence0Builder;
import fpml.confirmation.CompressionActivitySequence0.CompressionActivitySequence0BuilderImpl;
import fpml.confirmation.CompressionActivitySequence0.CompressionActivitySequence0Impl;
import fpml.confirmation.TradeIdentifier;
import fpml.confirmation.meta.CompressionActivitySequence0Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CompressionActivitySequence0", builder=CompressionActivitySequence0.CompressionActivitySequence0BuilderImpl.class, version="${project.version}")
public interface CompressionActivitySequence0 extends RosettaModelObject {

	CompressionActivitySequence0Meta metaData = new CompressionActivitySequence0Meta();

	/*********************** Getter Methods  ***********************/
	TradeIdentifier getReplacementTradeIdentifier();
	List<? extends TradeIdentifier> getOriginatingTradeIdentifier();

	/*********************** Build Methods  ***********************/
	CompressionActivitySequence0 build();
	
	CompressionActivitySequence0.CompressionActivitySequence0Builder toBuilder();
	
	static CompressionActivitySequence0.CompressionActivitySequence0Builder builder() {
		return new CompressionActivitySequence0.CompressionActivitySequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CompressionActivitySequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CompressionActivitySequence0> getType() {
		return CompressionActivitySequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("replacementTradeIdentifier"), processor, TradeIdentifier.class, getReplacementTradeIdentifier());
		processRosetta(path.newSubPath("originatingTradeIdentifier"), processor, TradeIdentifier.class, getOriginatingTradeIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CompressionActivitySequence0Builder extends CompressionActivitySequence0, RosettaModelObjectBuilder {
		TradeIdentifier.TradeIdentifierBuilder getOrCreateReplacementTradeIdentifier();
		TradeIdentifier.TradeIdentifierBuilder getReplacementTradeIdentifier();
		TradeIdentifier.TradeIdentifierBuilder getOrCreateOriginatingTradeIdentifier(int _index);
		List<? extends TradeIdentifier.TradeIdentifierBuilder> getOriginatingTradeIdentifier();
		CompressionActivitySequence0.CompressionActivitySequence0Builder setReplacementTradeIdentifier(TradeIdentifier replacementTradeIdentifier);
		CompressionActivitySequence0.CompressionActivitySequence0Builder addOriginatingTradeIdentifier(TradeIdentifier originatingTradeIdentifier0);
		CompressionActivitySequence0.CompressionActivitySequence0Builder addOriginatingTradeIdentifier(TradeIdentifier originatingTradeIdentifier1, int _idx);
		CompressionActivitySequence0.CompressionActivitySequence0Builder addOriginatingTradeIdentifier(List<? extends TradeIdentifier> originatingTradeIdentifier2);
		CompressionActivitySequence0.CompressionActivitySequence0Builder setOriginatingTradeIdentifier(List<? extends TradeIdentifier> originatingTradeIdentifier3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("replacementTradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getReplacementTradeIdentifier());
			processRosetta(path.newSubPath("originatingTradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getOriginatingTradeIdentifier());
		}
		

		CompressionActivitySequence0.CompressionActivitySequence0Builder prune();
	}

	/*********************** Immutable Implementation of CompressionActivitySequence0  ***********************/
	class CompressionActivitySequence0Impl implements CompressionActivitySequence0 {
		private final TradeIdentifier replacementTradeIdentifier;
		private final List<? extends TradeIdentifier> originatingTradeIdentifier;
		
		protected CompressionActivitySequence0Impl(CompressionActivitySequence0.CompressionActivitySequence0Builder builder) {
			this.replacementTradeIdentifier = ofNullable(builder.getReplacementTradeIdentifier()).map(f->f.build()).orElse(null);
			this.originatingTradeIdentifier = ofNullable(builder.getOriginatingTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("replacementTradeIdentifier")
		public TradeIdentifier getReplacementTradeIdentifier() {
			return replacementTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("originatingTradeIdentifier")
		public List<? extends TradeIdentifier> getOriginatingTradeIdentifier() {
			return originatingTradeIdentifier;
		}
		
		@Override
		public CompressionActivitySequence0 build() {
			return this;
		}
		
		@Override
		public CompressionActivitySequence0.CompressionActivitySequence0Builder toBuilder() {
			CompressionActivitySequence0.CompressionActivitySequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CompressionActivitySequence0.CompressionActivitySequence0Builder builder) {
			ofNullable(getReplacementTradeIdentifier()).ifPresent(builder::setReplacementTradeIdentifier);
			ofNullable(getOriginatingTradeIdentifier()).ifPresent(builder::setOriginatingTradeIdentifier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CompressionActivitySequence0 _that = getType().cast(o);
		
			if (!Objects.equals(replacementTradeIdentifier, _that.getReplacementTradeIdentifier())) return false;
			if (!ListEquals.listEquals(originatingTradeIdentifier, _that.getOriginatingTradeIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (replacementTradeIdentifier != null ? replacementTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (originatingTradeIdentifier != null ? originatingTradeIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CompressionActivitySequence0 {" +
				"replacementTradeIdentifier=" + this.replacementTradeIdentifier + ", " +
				"originatingTradeIdentifier=" + this.originatingTradeIdentifier +
			'}';
		}
	}

	/*********************** Builder Implementation of CompressionActivitySequence0  ***********************/
	class CompressionActivitySequence0BuilderImpl implements CompressionActivitySequence0.CompressionActivitySequence0Builder {
	
		protected TradeIdentifier.TradeIdentifierBuilder replacementTradeIdentifier;
		protected List<TradeIdentifier.TradeIdentifierBuilder> originatingTradeIdentifier = new ArrayList<>();
	
		public CompressionActivitySequence0BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("replacementTradeIdentifier")
		public TradeIdentifier.TradeIdentifierBuilder getReplacementTradeIdentifier() {
			return replacementTradeIdentifier;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateReplacementTradeIdentifier() {
			TradeIdentifier.TradeIdentifierBuilder result;
			if (replacementTradeIdentifier!=null) {
				result = replacementTradeIdentifier;
			}
			else {
				result = replacementTradeIdentifier = TradeIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("originatingTradeIdentifier")
		public List<? extends TradeIdentifier.TradeIdentifierBuilder> getOriginatingTradeIdentifier() {
			return originatingTradeIdentifier;
		}
		
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateOriginatingTradeIdentifier(int _index) {
		
			if (originatingTradeIdentifier==null) {
				this.originatingTradeIdentifier = new ArrayList<>();
			}
			TradeIdentifier.TradeIdentifierBuilder result;
			return getIndex(originatingTradeIdentifier, _index, () -> {
						TradeIdentifier.TradeIdentifierBuilder newOriginatingTradeIdentifier = TradeIdentifier.builder();
						return newOriginatingTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("replacementTradeIdentifier")
		public CompressionActivitySequence0.CompressionActivitySequence0Builder setReplacementTradeIdentifier(TradeIdentifier replacementTradeIdentifier) {
			this.replacementTradeIdentifier = replacementTradeIdentifier==null?null:replacementTradeIdentifier.toBuilder();
			return this;
		}
		@Override
		public CompressionActivitySequence0.CompressionActivitySequence0Builder addOriginatingTradeIdentifier(TradeIdentifier originatingTradeIdentifier) {
			if (originatingTradeIdentifier!=null) this.originatingTradeIdentifier.add(originatingTradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public CompressionActivitySequence0.CompressionActivitySequence0Builder addOriginatingTradeIdentifier(TradeIdentifier originatingTradeIdentifier, int _idx) {
			getIndex(this.originatingTradeIdentifier, _idx, () -> originatingTradeIdentifier.toBuilder());
			return this;
		}
		@Override 
		public CompressionActivitySequence0.CompressionActivitySequence0Builder addOriginatingTradeIdentifier(List<? extends TradeIdentifier> originatingTradeIdentifiers) {
			if (originatingTradeIdentifiers != null) {
				for (TradeIdentifier toAdd : originatingTradeIdentifiers) {
					this.originatingTradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("originatingTradeIdentifier")
		public CompressionActivitySequence0.CompressionActivitySequence0Builder setOriginatingTradeIdentifier(List<? extends TradeIdentifier> originatingTradeIdentifiers) {
			if (originatingTradeIdentifiers == null)  {
				this.originatingTradeIdentifier = new ArrayList<>();
			}
			else {
				this.originatingTradeIdentifier = originatingTradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public CompressionActivitySequence0 build() {
			return new CompressionActivitySequence0.CompressionActivitySequence0Impl(this);
		}
		
		@Override
		public CompressionActivitySequence0.CompressionActivitySequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CompressionActivitySequence0.CompressionActivitySequence0Builder prune() {
			if (replacementTradeIdentifier!=null && !replacementTradeIdentifier.prune().hasData()) replacementTradeIdentifier = null;
			originatingTradeIdentifier = originatingTradeIdentifier.stream().filter(b->b!=null).<TradeIdentifier.TradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReplacementTradeIdentifier()!=null && getReplacementTradeIdentifier().hasData()) return true;
			if (getOriginatingTradeIdentifier()!=null && getOriginatingTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CompressionActivitySequence0.CompressionActivitySequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CompressionActivitySequence0.CompressionActivitySequence0Builder o = (CompressionActivitySequence0.CompressionActivitySequence0Builder) other;
			
			merger.mergeRosetta(getReplacementTradeIdentifier(), o.getReplacementTradeIdentifier(), this::setReplacementTradeIdentifier);
			merger.mergeRosetta(getOriginatingTradeIdentifier(), o.getOriginatingTradeIdentifier(), this::getOrCreateOriginatingTradeIdentifier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CompressionActivitySequence0 _that = getType().cast(o);
		
			if (!Objects.equals(replacementTradeIdentifier, _that.getReplacementTradeIdentifier())) return false;
			if (!ListEquals.listEquals(originatingTradeIdentifier, _that.getOriginatingTradeIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (replacementTradeIdentifier != null ? replacementTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (originatingTradeIdentifier != null ? originatingTradeIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CompressionActivitySequence0Builder {" +
				"replacementTradeIdentifier=" + this.replacementTradeIdentifier + ", " +
				"originatingTradeIdentifier=" + this.originatingTradeIdentifier +
			'}';
		}
	}
}
