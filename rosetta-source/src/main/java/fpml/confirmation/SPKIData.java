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
import fpml.confirmation.SPKIData;
import fpml.confirmation.SPKIData.SPKIDataBuilder;
import fpml.confirmation.SPKIData.SPKIDataBuilderImpl;
import fpml.confirmation.SPKIData.SPKIDataImpl;
import fpml.confirmation.SPKIDataType;
import fpml.confirmation.SPKIDataType.SPKIDataTypeBuilder;
import fpml.confirmation.SPKIDataType.SPKIDataTypeBuilderImpl;
import fpml.confirmation.SPKIDataType.SPKIDataTypeImpl;
import fpml.confirmation.SPKIDataTypeSequence;
import fpml.confirmation.meta.SPKIDataMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="SPKIData", builder=SPKIData.SPKIDataBuilderImpl.class, version="${project.version}")
public interface SPKIData extends SPKIDataType {

	SPKIDataMeta metaData = new SPKIDataMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	SPKIData build();
	
	SPKIData.SPKIDataBuilder toBuilder();
	
	static SPKIData.SPKIDataBuilder builder() {
		return new SPKIData.SPKIDataBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SPKIData> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SPKIData> getType() {
		return SPKIData.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("spkiDataTypeSequence"), processor, SPKIDataTypeSequence.class, getSpkiDataTypeSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SPKIDataBuilder extends SPKIData, SPKIDataType.SPKIDataTypeBuilder {
		SPKIData.SPKIDataBuilder addSpkiDataTypeSequence(SPKIDataTypeSequence spkiDataTypeSequence0);
		SPKIData.SPKIDataBuilder addSpkiDataTypeSequence(SPKIDataTypeSequence spkiDataTypeSequence1, int _idx);
		SPKIData.SPKIDataBuilder addSpkiDataTypeSequence(List<? extends SPKIDataTypeSequence> spkiDataTypeSequence2);
		SPKIData.SPKIDataBuilder setSpkiDataTypeSequence(List<? extends SPKIDataTypeSequence> spkiDataTypeSequence3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("spkiDataTypeSequence"), processor, SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder.class, getSpkiDataTypeSequence());
		}
		

		SPKIData.SPKIDataBuilder prune();
	}

	/*********************** Immutable Implementation of SPKIData  ***********************/
	class SPKIDataImpl extends SPKIDataType.SPKIDataTypeImpl implements SPKIData {
		
		protected SPKIDataImpl(SPKIData.SPKIDataBuilder builder) {
			super(builder);
		}
		
		@Override
		public SPKIData build() {
			return this;
		}
		
		@Override
		public SPKIData.SPKIDataBuilder toBuilder() {
			SPKIData.SPKIDataBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SPKIData.SPKIDataBuilder builder) {
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
			return "SPKIData {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SPKIData  ***********************/
	class SPKIDataBuilderImpl extends SPKIDataType.SPKIDataTypeBuilderImpl  implements SPKIData.SPKIDataBuilder {
	
	
		public SPKIDataBuilderImpl() {
		}
	
		@Override
		public SPKIData.SPKIDataBuilder addSpkiDataTypeSequence(SPKIDataTypeSequence spkiDataTypeSequence) {
			if (spkiDataTypeSequence!=null) this.spkiDataTypeSequence.add(spkiDataTypeSequence.toBuilder());
			return this;
		}
		
		@Override
		public SPKIData.SPKIDataBuilder addSpkiDataTypeSequence(SPKIDataTypeSequence spkiDataTypeSequence, int _idx) {
			getIndex(this.spkiDataTypeSequence, _idx, () -> spkiDataTypeSequence.toBuilder());
			return this;
		}
		@Override 
		public SPKIData.SPKIDataBuilder addSpkiDataTypeSequence(List<? extends SPKIDataTypeSequence> spkiDataTypeSequences) {
			if (spkiDataTypeSequences != null) {
				for (SPKIDataTypeSequence toAdd : spkiDataTypeSequences) {
					this.spkiDataTypeSequence.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("spkiDataTypeSequence")
		public SPKIData.SPKIDataBuilder setSpkiDataTypeSequence(List<? extends SPKIDataTypeSequence> spkiDataTypeSequences) {
			if (spkiDataTypeSequences == null)  {
				this.spkiDataTypeSequence = new ArrayList<>();
			}
			else {
				this.spkiDataTypeSequence = spkiDataTypeSequences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public SPKIData build() {
			return new SPKIData.SPKIDataImpl(this);
		}
		
		@Override
		public SPKIData.SPKIDataBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SPKIData.SPKIDataBuilder prune() {
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
		public SPKIData.SPKIDataBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SPKIData.SPKIDataBuilder o = (SPKIData.SPKIDataBuilder) other;
			
			
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
			return "SPKIDataBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
