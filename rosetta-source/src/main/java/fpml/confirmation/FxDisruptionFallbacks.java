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
import fpml.confirmation.FxDisruptionFallback;
import fpml.confirmation.FxDisruptionFallbacks;
import fpml.confirmation.FxDisruptionFallbacks.FxDisruptionFallbacksBuilder;
import fpml.confirmation.FxDisruptionFallbacks.FxDisruptionFallbacksBuilderImpl;
import fpml.confirmation.FxDisruptionFallbacks.FxDisruptionFallbacksImpl;
import fpml.confirmation.meta.FxDisruptionFallbacksMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A container for the disruption fallback set
 * @version ${project.version}
 */
@RosettaDataType(value="FxDisruptionFallbacks", builder=FxDisruptionFallbacks.FxDisruptionFallbacksBuilderImpl.class, version="${project.version}")
public interface FxDisruptionFallbacks extends RosettaModelObject {

	FxDisruptionFallbacksMeta metaData = new FxDisruptionFallbacksMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends FxDisruptionFallback> getFxDisruptionFallback();

	/*********************** Build Methods  ***********************/
	FxDisruptionFallbacks build();
	
	FxDisruptionFallbacks.FxDisruptionFallbacksBuilder toBuilder();
	
	static FxDisruptionFallbacks.FxDisruptionFallbacksBuilder builder() {
		return new FxDisruptionFallbacks.FxDisruptionFallbacksBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxDisruptionFallbacks> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxDisruptionFallbacks> getType() {
		return FxDisruptionFallbacks.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fxDisruptionFallback"), processor, FxDisruptionFallback.class, getFxDisruptionFallback());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxDisruptionFallbacksBuilder extends FxDisruptionFallbacks, RosettaModelObjectBuilder {
		FxDisruptionFallback.FxDisruptionFallbackBuilder getOrCreateFxDisruptionFallback(int _index);
		List<? extends FxDisruptionFallback.FxDisruptionFallbackBuilder> getFxDisruptionFallback();
		FxDisruptionFallbacks.FxDisruptionFallbacksBuilder addFxDisruptionFallback(FxDisruptionFallback fxDisruptionFallback0);
		FxDisruptionFallbacks.FxDisruptionFallbacksBuilder addFxDisruptionFallback(FxDisruptionFallback fxDisruptionFallback1, int _idx);
		FxDisruptionFallbacks.FxDisruptionFallbacksBuilder addFxDisruptionFallback(List<? extends FxDisruptionFallback> fxDisruptionFallback2);
		FxDisruptionFallbacks.FxDisruptionFallbacksBuilder setFxDisruptionFallback(List<? extends FxDisruptionFallback> fxDisruptionFallback3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fxDisruptionFallback"), processor, FxDisruptionFallback.FxDisruptionFallbackBuilder.class, getFxDisruptionFallback());
		}
		

		FxDisruptionFallbacks.FxDisruptionFallbacksBuilder prune();
	}

	/*********************** Immutable Implementation of FxDisruptionFallbacks  ***********************/
	class FxDisruptionFallbacksImpl implements FxDisruptionFallbacks {
		private final List<? extends FxDisruptionFallback> fxDisruptionFallback;
		
		protected FxDisruptionFallbacksImpl(FxDisruptionFallbacks.FxDisruptionFallbacksBuilder builder) {
			this.fxDisruptionFallback = ofNullable(builder.getFxDisruptionFallback()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fxDisruptionFallback")
		public List<? extends FxDisruptionFallback> getFxDisruptionFallback() {
			return fxDisruptionFallback;
		}
		
		@Override
		public FxDisruptionFallbacks build() {
			return this;
		}
		
		@Override
		public FxDisruptionFallbacks.FxDisruptionFallbacksBuilder toBuilder() {
			FxDisruptionFallbacks.FxDisruptionFallbacksBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxDisruptionFallbacks.FxDisruptionFallbacksBuilder builder) {
			ofNullable(getFxDisruptionFallback()).ifPresent(builder::setFxDisruptionFallback);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxDisruptionFallbacks _that = getType().cast(o);
		
			if (!ListEquals.listEquals(fxDisruptionFallback, _that.getFxDisruptionFallback())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxDisruptionFallback != null ? fxDisruptionFallback.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDisruptionFallbacks {" +
				"fxDisruptionFallback=" + this.fxDisruptionFallback +
			'}';
		}
	}

	/*********************** Builder Implementation of FxDisruptionFallbacks  ***********************/
	class FxDisruptionFallbacksBuilderImpl implements FxDisruptionFallbacks.FxDisruptionFallbacksBuilder {
	
		protected List<FxDisruptionFallback.FxDisruptionFallbackBuilder> fxDisruptionFallback = new ArrayList<>();
	
		public FxDisruptionFallbacksBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fxDisruptionFallback")
		public List<? extends FxDisruptionFallback.FxDisruptionFallbackBuilder> getFxDisruptionFallback() {
			return fxDisruptionFallback;
		}
		
		@Override
		public FxDisruptionFallback.FxDisruptionFallbackBuilder getOrCreateFxDisruptionFallback(int _index) {
		
			if (fxDisruptionFallback==null) {
				this.fxDisruptionFallback = new ArrayList<>();
			}
			FxDisruptionFallback.FxDisruptionFallbackBuilder result;
			return getIndex(fxDisruptionFallback, _index, () -> {
						FxDisruptionFallback.FxDisruptionFallbackBuilder newFxDisruptionFallback = FxDisruptionFallback.builder();
						return newFxDisruptionFallback;
					});
		}
		
		@Override
		@RosettaAttribute("fxDisruptionFallback")
		public FxDisruptionFallbacks.FxDisruptionFallbacksBuilder addFxDisruptionFallback(FxDisruptionFallback fxDisruptionFallback) {
			if (fxDisruptionFallback!=null) this.fxDisruptionFallback.add(fxDisruptionFallback.toBuilder());
			return this;
		}
		
		@Override
		public FxDisruptionFallbacks.FxDisruptionFallbacksBuilder addFxDisruptionFallback(FxDisruptionFallback fxDisruptionFallback, int _idx) {
			getIndex(this.fxDisruptionFallback, _idx, () -> fxDisruptionFallback.toBuilder());
			return this;
		}
		@Override 
		public FxDisruptionFallbacks.FxDisruptionFallbacksBuilder addFxDisruptionFallback(List<? extends FxDisruptionFallback> fxDisruptionFallbacks) {
			if (fxDisruptionFallbacks != null) {
				for (FxDisruptionFallback toAdd : fxDisruptionFallbacks) {
					this.fxDisruptionFallback.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxDisruptionFallbacks.FxDisruptionFallbacksBuilder setFxDisruptionFallback(List<? extends FxDisruptionFallback> fxDisruptionFallbacks) {
			if (fxDisruptionFallbacks == null)  {
				this.fxDisruptionFallback = new ArrayList<>();
			}
			else {
				this.fxDisruptionFallback = fxDisruptionFallbacks.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FxDisruptionFallbacks build() {
			return new FxDisruptionFallbacks.FxDisruptionFallbacksImpl(this);
		}
		
		@Override
		public FxDisruptionFallbacks.FxDisruptionFallbacksBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDisruptionFallbacks.FxDisruptionFallbacksBuilder prune() {
			fxDisruptionFallback = fxDisruptionFallback.stream().filter(b->b!=null).<FxDisruptionFallback.FxDisruptionFallbackBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFxDisruptionFallback()!=null && getFxDisruptionFallback().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDisruptionFallbacks.FxDisruptionFallbacksBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxDisruptionFallbacks.FxDisruptionFallbacksBuilder o = (FxDisruptionFallbacks.FxDisruptionFallbacksBuilder) other;
			
			merger.mergeRosetta(getFxDisruptionFallback(), o.getFxDisruptionFallback(), this::getOrCreateFxDisruptionFallback);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxDisruptionFallbacks _that = getType().cast(o);
		
			if (!ListEquals.listEquals(fxDisruptionFallback, _that.getFxDisruptionFallback())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxDisruptionFallback != null ? fxDisruptionFallback.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDisruptionFallbacksBuilder {" +
				"fxDisruptionFallback=" + this.fxDisruptionFallback +
			'}';
		}
	}
}
