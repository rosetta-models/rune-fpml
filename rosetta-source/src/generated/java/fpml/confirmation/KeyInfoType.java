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
import fpml.confirmation.KeyInfoType;
import fpml.confirmation.KeyInfoType.KeyInfoTypeBuilder;
import fpml.confirmation.KeyInfoType.KeyInfoTypeBuilderImpl;
import fpml.confirmation.KeyInfoType.KeyInfoTypeImpl;
import fpml.confirmation.KeyInfoTypeChoice;
import fpml.confirmation.meta.KeyInfoTypeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="KeyInfoType", builder=KeyInfoType.KeyInfoTypeBuilderImpl.class, version="${project.version}")
public interface KeyInfoType extends RosettaModelObject {

	KeyInfoTypeMeta metaData = new KeyInfoTypeMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends KeyInfoTypeChoice> getKeyInfoTypeChoice();
	String getId();

	/*********************** Build Methods  ***********************/
	KeyInfoType build();
	
	KeyInfoType.KeyInfoTypeBuilder toBuilder();
	
	static KeyInfoType.KeyInfoTypeBuilder builder() {
		return new KeyInfoType.KeyInfoTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends KeyInfoType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends KeyInfoType> getType() {
		return KeyInfoType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("keyInfoTypeChoice"), processor, KeyInfoTypeChoice.class, getKeyInfoTypeChoice());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface KeyInfoTypeBuilder extends KeyInfoType, RosettaModelObjectBuilder {
		KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder getOrCreateKeyInfoTypeChoice(int _index);
		List<? extends KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder> getKeyInfoTypeChoice();
		KeyInfoType.KeyInfoTypeBuilder addKeyInfoTypeChoice(KeyInfoTypeChoice keyInfoTypeChoice0);
		KeyInfoType.KeyInfoTypeBuilder addKeyInfoTypeChoice(KeyInfoTypeChoice keyInfoTypeChoice1, int _idx);
		KeyInfoType.KeyInfoTypeBuilder addKeyInfoTypeChoice(List<? extends KeyInfoTypeChoice> keyInfoTypeChoice2);
		KeyInfoType.KeyInfoTypeBuilder setKeyInfoTypeChoice(List<? extends KeyInfoTypeChoice> keyInfoTypeChoice3);
		KeyInfoType.KeyInfoTypeBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("keyInfoTypeChoice"), processor, KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder.class, getKeyInfoTypeChoice());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		KeyInfoType.KeyInfoTypeBuilder prune();
	}

	/*********************** Immutable Implementation of KeyInfoType  ***********************/
	class KeyInfoTypeImpl implements KeyInfoType {
		private final List<? extends KeyInfoTypeChoice> keyInfoTypeChoice;
		private final String id;
		
		protected KeyInfoTypeImpl(KeyInfoType.KeyInfoTypeBuilder builder) {
			this.keyInfoTypeChoice = ofNullable(builder.getKeyInfoTypeChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("keyInfoTypeChoice")
		public List<? extends KeyInfoTypeChoice> getKeyInfoTypeChoice() {
			return keyInfoTypeChoice;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public KeyInfoType build() {
			return this;
		}
		
		@Override
		public KeyInfoType.KeyInfoTypeBuilder toBuilder() {
			KeyInfoType.KeyInfoTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(KeyInfoType.KeyInfoTypeBuilder builder) {
			ofNullable(getKeyInfoTypeChoice()).ifPresent(builder::setKeyInfoTypeChoice);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			KeyInfoType _that = getType().cast(o);
		
			if (!ListEquals.listEquals(keyInfoTypeChoice, _that.getKeyInfoTypeChoice())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (keyInfoTypeChoice != null ? keyInfoTypeChoice.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "KeyInfoType {" +
				"keyInfoTypeChoice=" + this.keyInfoTypeChoice + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of KeyInfoType  ***********************/
	class KeyInfoTypeBuilderImpl implements KeyInfoType.KeyInfoTypeBuilder {
	
		protected List<KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder> keyInfoTypeChoice = new ArrayList<>();
		protected String id;
	
		public KeyInfoTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("keyInfoTypeChoice")
		public List<? extends KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder> getKeyInfoTypeChoice() {
			return keyInfoTypeChoice;
		}
		
		public KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder getOrCreateKeyInfoTypeChoice(int _index) {
		
			if (keyInfoTypeChoice==null) {
				this.keyInfoTypeChoice = new ArrayList<>();
			}
			KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder result;
			return getIndex(keyInfoTypeChoice, _index, () -> {
						KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder newKeyInfoTypeChoice = KeyInfoTypeChoice.builder();
						return newKeyInfoTypeChoice;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public KeyInfoType.KeyInfoTypeBuilder addKeyInfoTypeChoice(KeyInfoTypeChoice keyInfoTypeChoice) {
			if (keyInfoTypeChoice!=null) this.keyInfoTypeChoice.add(keyInfoTypeChoice.toBuilder());
			return this;
		}
		
		@Override
		public KeyInfoType.KeyInfoTypeBuilder addKeyInfoTypeChoice(KeyInfoTypeChoice keyInfoTypeChoice, int _idx) {
			getIndex(this.keyInfoTypeChoice, _idx, () -> keyInfoTypeChoice.toBuilder());
			return this;
		}
		@Override 
		public KeyInfoType.KeyInfoTypeBuilder addKeyInfoTypeChoice(List<? extends KeyInfoTypeChoice> keyInfoTypeChoices) {
			if (keyInfoTypeChoices != null) {
				for (KeyInfoTypeChoice toAdd : keyInfoTypeChoices) {
					this.keyInfoTypeChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("keyInfoTypeChoice")
		public KeyInfoType.KeyInfoTypeBuilder setKeyInfoTypeChoice(List<? extends KeyInfoTypeChoice> keyInfoTypeChoices) {
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
		public KeyInfoType.KeyInfoTypeBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public KeyInfoType build() {
			return new KeyInfoType.KeyInfoTypeImpl(this);
		}
		
		@Override
		public KeyInfoType.KeyInfoTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public KeyInfoType.KeyInfoTypeBuilder prune() {
			keyInfoTypeChoice = keyInfoTypeChoice.stream().filter(b->b!=null).<KeyInfoTypeChoice.KeyInfoTypeChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getKeyInfoTypeChoice()!=null && getKeyInfoTypeChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public KeyInfoType.KeyInfoTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			KeyInfoType.KeyInfoTypeBuilder o = (KeyInfoType.KeyInfoTypeBuilder) other;
			
			merger.mergeRosetta(getKeyInfoTypeChoice(), o.getKeyInfoTypeChoice(), this::getOrCreateKeyInfoTypeChoice);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			KeyInfoType _that = getType().cast(o);
		
			if (!ListEquals.listEquals(keyInfoTypeChoice, _that.getKeyInfoTypeChoice())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (keyInfoTypeChoice != null ? keyInfoTypeChoice.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "KeyInfoTypeBuilder {" +
				"keyInfoTypeChoice=" + this.keyInfoTypeChoice + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
