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
import fpml.confirmation.Asset;
import fpml.confirmation.Asset.AssetBuilder;
import fpml.confirmation.Asset.AssetBuilderImpl;
import fpml.confirmation.Asset.AssetImpl;
import fpml.confirmation.IdentifiedAsset;
import fpml.confirmation.IdentifiedAsset.IdentifiedAssetBuilder;
import fpml.confirmation.IdentifiedAsset.IdentifiedAssetBuilderImpl;
import fpml.confirmation.IdentifiedAsset.IdentifiedAssetImpl;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.meta.IdentifiedAssetMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A generic type describing an identified asset.
 * @version ${project.version}
 */
@RosettaDataType(value="IdentifiedAsset", builder=IdentifiedAsset.IdentifiedAssetBuilderImpl.class, version="${project.version}")
public interface IdentifiedAsset extends Asset {

	IdentifiedAssetMeta metaData = new IdentifiedAssetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identification of the underlying asset, using public and/or private identifiers.
	 */
	List<? extends InstrumentId> getInstrumentId();
	/**
	 * Long name of the underlying asset.
	 */
	String getDescription();

	/*********************** Build Methods  ***********************/
	IdentifiedAsset build();
	
	IdentifiedAsset.IdentifiedAssetBuilder toBuilder();
	
	static IdentifiedAsset.IdentifiedAssetBuilder builder() {
		return new IdentifiedAsset.IdentifiedAssetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IdentifiedAsset> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends IdentifiedAsset> getType() {
		return IdentifiedAsset.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IdentifiedAssetBuilder extends IdentifiedAsset, Asset.AssetBuilder {
		InstrumentId.InstrumentIdBuilder getOrCreateInstrumentId(int _index);
		List<? extends InstrumentId.InstrumentIdBuilder> getInstrumentId();
		IdentifiedAsset.IdentifiedAssetBuilder setId(String id);
		IdentifiedAsset.IdentifiedAssetBuilder addInstrumentId(InstrumentId instrumentId0);
		IdentifiedAsset.IdentifiedAssetBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		IdentifiedAsset.IdentifiedAssetBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		IdentifiedAsset.IdentifiedAssetBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		IdentifiedAsset.IdentifiedAssetBuilder setDescription(String description);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		}
		

		IdentifiedAsset.IdentifiedAssetBuilder prune();
	}

	/*********************** Immutable Implementation of IdentifiedAsset  ***********************/
	class IdentifiedAssetImpl extends Asset.AssetImpl implements IdentifiedAsset {
		private final List<? extends InstrumentId> instrumentId;
		private final String description;
		
		protected IdentifiedAssetImpl(IdentifiedAsset.IdentifiedAssetBuilder builder) {
			super(builder);
			this.instrumentId = ofNullable(builder.getInstrumentId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.description = builder.getDescription();
		}
		
		@Override
		@RosettaAttribute("instrumentId")
		public List<? extends InstrumentId> getInstrumentId() {
			return instrumentId;
		}
		
		@Override
		@RosettaAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		public IdentifiedAsset build() {
			return this;
		}
		
		@Override
		public IdentifiedAsset.IdentifiedAssetBuilder toBuilder() {
			IdentifiedAsset.IdentifiedAssetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IdentifiedAsset.IdentifiedAssetBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInstrumentId()).ifPresent(builder::setInstrumentId);
			ofNullable(getDescription()).ifPresent(builder::setDescription);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IdentifiedAsset _that = getType().cast(o);
		
			if (!ListEquals.listEquals(instrumentId, _that.getInstrumentId())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (instrumentId != null ? instrumentId.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IdentifiedAsset {" +
				"instrumentId=" + this.instrumentId + ", " +
				"description=" + this.description +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of IdentifiedAsset  ***********************/
	class IdentifiedAssetBuilderImpl extends Asset.AssetBuilderImpl  implements IdentifiedAsset.IdentifiedAssetBuilder {
	
		protected List<InstrumentId.InstrumentIdBuilder> instrumentId = new ArrayList<>();
		protected String description;
	
		public IdentifiedAssetBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("instrumentId")
		public List<? extends InstrumentId.InstrumentIdBuilder> getInstrumentId() {
			return instrumentId;
		}
		
		public InstrumentId.InstrumentIdBuilder getOrCreateInstrumentId(int _index) {
		
			if (instrumentId==null) {
				this.instrumentId = new ArrayList<>();
			}
			InstrumentId.InstrumentIdBuilder result;
			return getIndex(instrumentId, _index, () -> {
						InstrumentId.InstrumentIdBuilder newInstrumentId = InstrumentId.builder();
						return newInstrumentId;
					});
		}
		
		@Override
		@RosettaAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		@RosettaAttribute("id")
		public IdentifiedAsset.IdentifiedAssetBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public IdentifiedAsset.IdentifiedAssetBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public IdentifiedAsset.IdentifiedAssetBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public IdentifiedAsset.IdentifiedAssetBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("instrumentId")
		public IdentifiedAsset.IdentifiedAssetBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null)  {
				this.instrumentId = new ArrayList<>();
			}
			else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("description")
		public IdentifiedAsset.IdentifiedAssetBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		
		@Override
		public IdentifiedAsset build() {
			return new IdentifiedAsset.IdentifiedAssetImpl(this);
		}
		
		@Override
		public IdentifiedAsset.IdentifiedAssetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IdentifiedAsset.IdentifiedAssetBuilder prune() {
			super.prune();
			instrumentId = instrumentId.stream().filter(b->b!=null).<InstrumentId.InstrumentIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInstrumentId()!=null && getInstrumentId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDescription()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IdentifiedAsset.IdentifiedAssetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			IdentifiedAsset.IdentifiedAssetBuilder o = (IdentifiedAsset.IdentifiedAssetBuilder) other;
			
			merger.mergeRosetta(getInstrumentId(), o.getInstrumentId(), this::getOrCreateInstrumentId);
			
			merger.mergeBasic(getDescription(), o.getDescription(), this::setDescription);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IdentifiedAsset _that = getType().cast(o);
		
			if (!ListEquals.listEquals(instrumentId, _that.getInstrumentId())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (instrumentId != null ? instrumentId.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IdentifiedAssetBuilder {" +
				"instrumentId=" + this.instrumentId + ", " +
				"description=" + this.description +
			'}' + " " + super.toString();
		}
	}
}
