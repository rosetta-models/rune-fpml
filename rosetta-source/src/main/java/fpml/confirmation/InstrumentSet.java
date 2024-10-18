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
import fpml.confirmation.InstrumentSet;
import fpml.confirmation.InstrumentSet.InstrumentSetBuilder;
import fpml.confirmation.InstrumentSet.InstrumentSetBuilderImpl;
import fpml.confirmation.InstrumentSet.InstrumentSetImpl;
import fpml.confirmation.InstrumentSetSequence;
import fpml.confirmation.meta.InstrumentSetMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A collection of instruments usable for quotation purposes. In future releases, quotable derivative assets may be added after the underlying asset.
 * @version ${project.version}
 */
@RosettaDataType(value="InstrumentSet", builder=InstrumentSet.InstrumentSetBuilderImpl.class, version="${project.version}")
public interface InstrumentSet extends RosettaModelObject {

	InstrumentSetMeta metaData = new InstrumentSetMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends InstrumentSetSequence> getInstrumentSetSequence();

	/*********************** Build Methods  ***********************/
	InstrumentSet build();
	
	InstrumentSet.InstrumentSetBuilder toBuilder();
	
	static InstrumentSet.InstrumentSetBuilder builder() {
		return new InstrumentSet.InstrumentSetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InstrumentSet> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InstrumentSet> getType() {
		return InstrumentSet.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("instrumentSetSequence"), processor, InstrumentSetSequence.class, getInstrumentSetSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InstrumentSetBuilder extends InstrumentSet, RosettaModelObjectBuilder {
		InstrumentSetSequence.InstrumentSetSequenceBuilder getOrCreateInstrumentSetSequence(int _index);
		List<? extends InstrumentSetSequence.InstrumentSetSequenceBuilder> getInstrumentSetSequence();
		InstrumentSet.InstrumentSetBuilder addInstrumentSetSequence(InstrumentSetSequence instrumentSetSequence0);
		InstrumentSet.InstrumentSetBuilder addInstrumentSetSequence(InstrumentSetSequence instrumentSetSequence1, int _idx);
		InstrumentSet.InstrumentSetBuilder addInstrumentSetSequence(List<? extends InstrumentSetSequence> instrumentSetSequence2);
		InstrumentSet.InstrumentSetBuilder setInstrumentSetSequence(List<? extends InstrumentSetSequence> instrumentSetSequence3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("instrumentSetSequence"), processor, InstrumentSetSequence.InstrumentSetSequenceBuilder.class, getInstrumentSetSequence());
		}
		

		InstrumentSet.InstrumentSetBuilder prune();
	}

	/*********************** Immutable Implementation of InstrumentSet  ***********************/
	class InstrumentSetImpl implements InstrumentSet {
		private final List<? extends InstrumentSetSequence> instrumentSetSequence;
		
		protected InstrumentSetImpl(InstrumentSet.InstrumentSetBuilder builder) {
			this.instrumentSetSequence = ofNullable(builder.getInstrumentSetSequence()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("instrumentSetSequence")
		public List<? extends InstrumentSetSequence> getInstrumentSetSequence() {
			return instrumentSetSequence;
		}
		
		@Override
		public InstrumentSet build() {
			return this;
		}
		
		@Override
		public InstrumentSet.InstrumentSetBuilder toBuilder() {
			InstrumentSet.InstrumentSetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InstrumentSet.InstrumentSetBuilder builder) {
			ofNullable(getInstrumentSetSequence()).ifPresent(builder::setInstrumentSetSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InstrumentSet _that = getType().cast(o);
		
			if (!ListEquals.listEquals(instrumentSetSequence, _that.getInstrumentSetSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (instrumentSetSequence != null ? instrumentSetSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentSet {" +
				"instrumentSetSequence=" + this.instrumentSetSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of InstrumentSet  ***********************/
	class InstrumentSetBuilderImpl implements InstrumentSet.InstrumentSetBuilder {
	
		protected List<InstrumentSetSequence.InstrumentSetSequenceBuilder> instrumentSetSequence = new ArrayList<>();
	
		public InstrumentSetBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("instrumentSetSequence")
		public List<? extends InstrumentSetSequence.InstrumentSetSequenceBuilder> getInstrumentSetSequence() {
			return instrumentSetSequence;
		}
		
		@Override
		public InstrumentSetSequence.InstrumentSetSequenceBuilder getOrCreateInstrumentSetSequence(int _index) {
		
			if (instrumentSetSequence==null) {
				this.instrumentSetSequence = new ArrayList<>();
			}
			InstrumentSetSequence.InstrumentSetSequenceBuilder result;
			return getIndex(instrumentSetSequence, _index, () -> {
						InstrumentSetSequence.InstrumentSetSequenceBuilder newInstrumentSetSequence = InstrumentSetSequence.builder();
						return newInstrumentSetSequence;
					});
		}
		
		@Override
		@RosettaAttribute("instrumentSetSequence")
		public InstrumentSet.InstrumentSetBuilder addInstrumentSetSequence(InstrumentSetSequence instrumentSetSequence) {
			if (instrumentSetSequence!=null) this.instrumentSetSequence.add(instrumentSetSequence.toBuilder());
			return this;
		}
		
		@Override
		public InstrumentSet.InstrumentSetBuilder addInstrumentSetSequence(InstrumentSetSequence instrumentSetSequence, int _idx) {
			getIndex(this.instrumentSetSequence, _idx, () -> instrumentSetSequence.toBuilder());
			return this;
		}
		@Override 
		public InstrumentSet.InstrumentSetBuilder addInstrumentSetSequence(List<? extends InstrumentSetSequence> instrumentSetSequences) {
			if (instrumentSetSequences != null) {
				for (InstrumentSetSequence toAdd : instrumentSetSequences) {
					this.instrumentSetSequence.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public InstrumentSet.InstrumentSetBuilder setInstrumentSetSequence(List<? extends InstrumentSetSequence> instrumentSetSequences) {
			if (instrumentSetSequences == null)  {
				this.instrumentSetSequence = new ArrayList<>();
			}
			else {
				this.instrumentSetSequence = instrumentSetSequences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public InstrumentSet build() {
			return new InstrumentSet.InstrumentSetImpl(this);
		}
		
		@Override
		public InstrumentSet.InstrumentSetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentSet.InstrumentSetBuilder prune() {
			instrumentSetSequence = instrumentSetSequence.stream().filter(b->b!=null).<InstrumentSetSequence.InstrumentSetSequenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInstrumentSetSequence()!=null && getInstrumentSetSequence().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentSet.InstrumentSetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InstrumentSet.InstrumentSetBuilder o = (InstrumentSet.InstrumentSetBuilder) other;
			
			merger.mergeRosetta(getInstrumentSetSequence(), o.getInstrumentSetSequence(), this::getOrCreateInstrumentSetSequence);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InstrumentSet _that = getType().cast(o);
		
			if (!ListEquals.listEquals(instrumentSetSequence, _that.getInstrumentSetSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (instrumentSetSequence != null ? instrumentSetSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentSetBuilder {" +
				"instrumentSetSequence=" + this.instrumentSetSequence +
			'}';
		}
	}
}
