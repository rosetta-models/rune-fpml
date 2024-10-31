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
import fpml.confirmation.DealIdentifier;
import fpml.confirmation.DealIdentifier.DealIdentifierBuilder;
import fpml.confirmation.DealIdentifier.DealIdentifierBuilderImpl;
import fpml.confirmation.DealIdentifier.DealIdentifierImpl;
import fpml.confirmation.IdentifiedAsset;
import fpml.confirmation.IdentifiedAsset.IdentifiedAssetBuilder;
import fpml.confirmation.IdentifiedAsset.IdentifiedAssetBuilderImpl;
import fpml.confirmation.IdentifiedAsset.IdentifiedAssetImpl;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.meta.DealIdentifierMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * A unique reference to a syndicated bank loan deal (credit agreement).
 * @version ${project.version}
 */
@RosettaDataType(value="DealIdentifier", builder=DealIdentifier.DealIdentifierBuilderImpl.class, version="${project.version}")
public interface DealIdentifier extends IdentifiedAsset {

	DealIdentifierMeta metaData = new DealIdentifierMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	DealIdentifier build();
	
	DealIdentifier.DealIdentifierBuilder toBuilder();
	
	static DealIdentifier.DealIdentifierBuilder builder() {
		return new DealIdentifier.DealIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DealIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DealIdentifier> getType() {
		return DealIdentifier.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DealIdentifierBuilder extends DealIdentifier, IdentifiedAsset.IdentifiedAssetBuilder {
		DealIdentifier.DealIdentifierBuilder setId(String id);
		DealIdentifier.DealIdentifierBuilder addInstrumentId(InstrumentId instrumentId0);
		DealIdentifier.DealIdentifierBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		DealIdentifier.DealIdentifierBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		DealIdentifier.DealIdentifierBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		DealIdentifier.DealIdentifierBuilder setDescription(String description);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		}
		

		DealIdentifier.DealIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of DealIdentifier  ***********************/
	class DealIdentifierImpl extends IdentifiedAsset.IdentifiedAssetImpl implements DealIdentifier {
		
		protected DealIdentifierImpl(DealIdentifier.DealIdentifierBuilder builder) {
			super(builder);
		}
		
		@Override
		public DealIdentifier build() {
			return this;
		}
		
		@Override
		public DealIdentifier.DealIdentifierBuilder toBuilder() {
			DealIdentifier.DealIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DealIdentifier.DealIdentifierBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "DealIdentifier {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DealIdentifier  ***********************/
	class DealIdentifierBuilderImpl extends IdentifiedAsset.IdentifiedAssetBuilderImpl  implements DealIdentifier.DealIdentifierBuilder {
	
	
		public DealIdentifierBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public DealIdentifier.DealIdentifierBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("instrumentId")
		public DealIdentifier.DealIdentifierBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public DealIdentifier.DealIdentifierBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public DealIdentifier.DealIdentifierBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DealIdentifier.DealIdentifierBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public DealIdentifier.DealIdentifierBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		
		@Override
		public DealIdentifier build() {
			return new DealIdentifier.DealIdentifierImpl(this);
		}
		
		@Override
		public DealIdentifier.DealIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DealIdentifier.DealIdentifierBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DealIdentifier.DealIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			DealIdentifier.DealIdentifierBuilder o = (DealIdentifier.DealIdentifierBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "DealIdentifierBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
