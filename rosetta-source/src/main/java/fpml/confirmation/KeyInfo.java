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
import fpml.confirmation.KeyInfo;
import fpml.confirmation.KeyInfo.KeyInfoBuilder;
import fpml.confirmation.KeyInfo.KeyInfoBuilderImpl;
import fpml.confirmation.KeyInfo.KeyInfoImpl;
import fpml.confirmation.KeyInfoType;
import fpml.confirmation.KeyInfoType.KeyInfoTypeBuilder;
import fpml.confirmation.KeyInfoType.KeyInfoTypeBuilderImpl;
import fpml.confirmation.KeyInfoType.KeyInfoTypeImpl;
import fpml.confirmation.KeyInfoTypeChoice;
import fpml.confirmation.meta.KeyInfoMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="KeyInfo", builder=KeyInfo.KeyInfoBuilderImpl.class, version="${project.version}")
public interface KeyInfo extends KeyInfoType {

	KeyInfoMeta metaData = new KeyInfoMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	KeyInfo build();
	
	KeyInfo.KeyInfoBuilder toBuilder();
	
	static KeyInfo.KeyInfoBuilder builder() {
		return new KeyInfo.KeyInfoBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends KeyInfo> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends KeyInfo> getType() {
		return KeyInfo.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("keyInfoTypeChoice"), processor, KeyInfoTypeChoice.class, getKeyInfoTypeChoice());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface KeyInfoBuilder extends KeyInfo, KeyInfoType.KeyInfoTypeBuilder {
		KeyInfo.KeyInfoBuilder addKeyInfoTypeChoice(KeyInfoTypeChoice keyInfoTypeChoice0);
		KeyInfo.KeyInfoBuilder addKeyInfoTypeChoice(KeyInfoTypeChoice keyInfoTypeChoice1, int _idx);
		KeyInfo.KeyInfoBuilder addKeyInfoTypeChoice(List<? extends KeyInfoTypeChoice> keyInfoTypeChoice2);
		KeyInfo.KeyInfoBuilder setKeyInfoTypeChoice(List<? extends KeyInfoTypeChoice> keyInfoTypeChoice3);
		KeyInfo.KeyInfoBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("keyInfoTypeChoice"), processor, KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder.class, getKeyInfoTypeChoice());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		KeyInfo.KeyInfoBuilder prune();
	}

	/*********************** Immutable Implementation of KeyInfo  ***********************/
	class KeyInfoImpl extends KeyInfoType.KeyInfoTypeImpl implements KeyInfo {
		
		protected KeyInfoImpl(KeyInfo.KeyInfoBuilder builder) {
			super(builder);
		}
		
		@Override
		public KeyInfo build() {
			return this;
		}
		
		@Override
		public KeyInfo.KeyInfoBuilder toBuilder() {
			KeyInfo.KeyInfoBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(KeyInfo.KeyInfoBuilder builder) {
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
			return "KeyInfo {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of KeyInfo  ***********************/
	class KeyInfoBuilderImpl extends KeyInfoType.KeyInfoTypeBuilderImpl  implements KeyInfo.KeyInfoBuilder {
	
	
		public KeyInfoBuilderImpl() {
		}
	
		@Override
		public KeyInfo.KeyInfoBuilder addKeyInfoTypeChoice(KeyInfoTypeChoice keyInfoTypeChoice) {
			if (keyInfoTypeChoice!=null) this.keyInfoTypeChoice.add(keyInfoTypeChoice.toBuilder());
			return this;
		}
		
		@Override
		public KeyInfo.KeyInfoBuilder addKeyInfoTypeChoice(KeyInfoTypeChoice keyInfoTypeChoice, int _idx) {
			getIndex(this.keyInfoTypeChoice, _idx, () -> keyInfoTypeChoice.toBuilder());
			return this;
		}
		@Override 
		public KeyInfo.KeyInfoBuilder addKeyInfoTypeChoice(List<? extends KeyInfoTypeChoice> keyInfoTypeChoices) {
			if (keyInfoTypeChoices != null) {
				for (KeyInfoTypeChoice toAdd : keyInfoTypeChoices) {
					this.keyInfoTypeChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("keyInfoTypeChoice")
		public KeyInfo.KeyInfoBuilder setKeyInfoTypeChoice(List<? extends KeyInfoTypeChoice> keyInfoTypeChoices) {
			if (keyInfoTypeChoices == null)  {
				this.keyInfoTypeChoice = new ArrayList<>();
			}
			else {
				this.keyInfoTypeChoice = keyInfoTypeChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public KeyInfo.KeyInfoBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public KeyInfo build() {
			return new KeyInfo.KeyInfoImpl(this);
		}
		
		@Override
		public KeyInfo.KeyInfoBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public KeyInfo.KeyInfoBuilder prune() {
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
		public KeyInfo.KeyInfoBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			KeyInfo.KeyInfoBuilder o = (KeyInfo.KeyInfoBuilder) other;
			
			
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
			return "KeyInfoBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
