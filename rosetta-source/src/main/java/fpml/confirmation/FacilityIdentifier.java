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
import fpml.confirmation.FacilityIdentifier;
import fpml.confirmation.FacilityIdentifier.FacilityIdentifierBuilder;
import fpml.confirmation.FacilityIdentifier.FacilityIdentifierBuilderImpl;
import fpml.confirmation.FacilityIdentifier.FacilityIdentifierImpl;
import fpml.confirmation.IdentifiedAsset;
import fpml.confirmation.IdentifiedAsset.IdentifiedAssetBuilder;
import fpml.confirmation.IdentifiedAsset.IdentifiedAssetBuilderImpl;
import fpml.confirmation.IdentifiedAsset.IdentifiedAssetImpl;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.meta.FacilityIdentifierMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * A unique identifier to a facility.
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityIdentifier", builder=FacilityIdentifier.FacilityIdentifierBuilderImpl.class, version="${project.version}")
public interface FacilityIdentifier extends IdentifiedAsset {

	FacilityIdentifierMeta metaData = new FacilityIdentifierMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FacilityIdentifier build();
	
	FacilityIdentifier.FacilityIdentifierBuilder toBuilder();
	
	static FacilityIdentifier.FacilityIdentifierBuilder builder() {
		return new FacilityIdentifier.FacilityIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityIdentifier> getType() {
		return FacilityIdentifier.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityIdentifierBuilder extends FacilityIdentifier, IdentifiedAsset.IdentifiedAssetBuilder {
		FacilityIdentifier.FacilityIdentifierBuilder setId(String id);
		FacilityIdentifier.FacilityIdentifierBuilder addInstrumentId(InstrumentId instrumentId0);
		FacilityIdentifier.FacilityIdentifierBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		FacilityIdentifier.FacilityIdentifierBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		FacilityIdentifier.FacilityIdentifierBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		FacilityIdentifier.FacilityIdentifierBuilder setDescription(String description);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		}
		

		FacilityIdentifier.FacilityIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityIdentifier  ***********************/
	class FacilityIdentifierImpl extends IdentifiedAsset.IdentifiedAssetImpl implements FacilityIdentifier {
		
		protected FacilityIdentifierImpl(FacilityIdentifier.FacilityIdentifierBuilder builder) {
			super(builder);
		}
		
		@Override
		public FacilityIdentifier build() {
			return this;
		}
		
		@Override
		public FacilityIdentifier.FacilityIdentifierBuilder toBuilder() {
			FacilityIdentifier.FacilityIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityIdentifier.FacilityIdentifierBuilder builder) {
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
			return "FacilityIdentifier {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FacilityIdentifier  ***********************/
	class FacilityIdentifierBuilderImpl extends IdentifiedAsset.IdentifiedAssetBuilderImpl  implements FacilityIdentifier.FacilityIdentifierBuilder {
	
	
		public FacilityIdentifierBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public FacilityIdentifier.FacilityIdentifierBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public FacilityIdentifier.FacilityIdentifierBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public FacilityIdentifier.FacilityIdentifierBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public FacilityIdentifier.FacilityIdentifierBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("instrumentId")
		public FacilityIdentifier.FacilityIdentifierBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public FacilityIdentifier.FacilityIdentifierBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		
		@Override
		public FacilityIdentifier build() {
			return new FacilityIdentifier.FacilityIdentifierImpl(this);
		}
		
		@Override
		public FacilityIdentifier.FacilityIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityIdentifier.FacilityIdentifierBuilder prune() {
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
		public FacilityIdentifier.FacilityIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FacilityIdentifier.FacilityIdentifierBuilder o = (FacilityIdentifier.FacilityIdentifierBuilder) other;
			
			
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
			return "FacilityIdentifierBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
