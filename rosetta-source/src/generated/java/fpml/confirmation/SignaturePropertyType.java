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
import fpml.confirmation.SignaturePropertyType;
import fpml.confirmation.SignaturePropertyType.SignaturePropertyTypeBuilder;
import fpml.confirmation.SignaturePropertyType.SignaturePropertyTypeBuilderImpl;
import fpml.confirmation.SignaturePropertyType.SignaturePropertyTypeImpl;
import fpml.confirmation.SignaturePropertyTypeChoice;
import fpml.confirmation.meta.SignaturePropertyTypeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="SignaturePropertyType", builder=SignaturePropertyType.SignaturePropertyTypeBuilderImpl.class, version="${project.version}")
public interface SignaturePropertyType extends RosettaModelObject {

	SignaturePropertyTypeMeta metaData = new SignaturePropertyTypeMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends SignaturePropertyTypeChoice> getSignaturePropertyTypeChoice();
	String getTarget();
	String getId();

	/*********************** Build Methods  ***********************/
	SignaturePropertyType build();
	
	SignaturePropertyType.SignaturePropertyTypeBuilder toBuilder();
	
	static SignaturePropertyType.SignaturePropertyTypeBuilder builder() {
		return new SignaturePropertyType.SignaturePropertyTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SignaturePropertyType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SignaturePropertyType> getType() {
		return SignaturePropertyType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("signaturePropertyTypeChoice"), processor, SignaturePropertyTypeChoice.class, getSignaturePropertyTypeChoice());
		processor.processBasic(path.newSubPath("target"), String.class, getTarget(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SignaturePropertyTypeBuilder extends SignaturePropertyType, RosettaModelObjectBuilder {
		SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder getOrCreateSignaturePropertyTypeChoice(int _index);
		List<? extends SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder> getSignaturePropertyTypeChoice();
		SignaturePropertyType.SignaturePropertyTypeBuilder addSignaturePropertyTypeChoice(SignaturePropertyTypeChoice signaturePropertyTypeChoice0);
		SignaturePropertyType.SignaturePropertyTypeBuilder addSignaturePropertyTypeChoice(SignaturePropertyTypeChoice signaturePropertyTypeChoice1, int _idx);
		SignaturePropertyType.SignaturePropertyTypeBuilder addSignaturePropertyTypeChoice(List<? extends SignaturePropertyTypeChoice> signaturePropertyTypeChoice2);
		SignaturePropertyType.SignaturePropertyTypeBuilder setSignaturePropertyTypeChoice(List<? extends SignaturePropertyTypeChoice> signaturePropertyTypeChoice3);
		SignaturePropertyType.SignaturePropertyTypeBuilder setTarget(String target);
		SignaturePropertyType.SignaturePropertyTypeBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("signaturePropertyTypeChoice"), processor, SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder.class, getSignaturePropertyTypeChoice());
			processor.processBasic(path.newSubPath("target"), String.class, getTarget(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		SignaturePropertyType.SignaturePropertyTypeBuilder prune();
	}

	/*********************** Immutable Implementation of SignaturePropertyType  ***********************/
	class SignaturePropertyTypeImpl implements SignaturePropertyType {
		private final List<? extends SignaturePropertyTypeChoice> signaturePropertyTypeChoice;
		private final String target;
		private final String id;
		
		protected SignaturePropertyTypeImpl(SignaturePropertyType.SignaturePropertyTypeBuilder builder) {
			this.signaturePropertyTypeChoice = ofNullable(builder.getSignaturePropertyTypeChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.target = builder.getTarget();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("signaturePropertyTypeChoice")
		public List<? extends SignaturePropertyTypeChoice> getSignaturePropertyTypeChoice() {
			return signaturePropertyTypeChoice;
		}
		
		@Override
		@RosettaAttribute("target")
		public String getTarget() {
			return target;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public SignaturePropertyType build() {
			return this;
		}
		
		@Override
		public SignaturePropertyType.SignaturePropertyTypeBuilder toBuilder() {
			SignaturePropertyType.SignaturePropertyTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SignaturePropertyType.SignaturePropertyTypeBuilder builder) {
			ofNullable(getSignaturePropertyTypeChoice()).ifPresent(builder::setSignaturePropertyTypeChoice);
			ofNullable(getTarget()).ifPresent(builder::setTarget);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SignaturePropertyType _that = getType().cast(o);
		
			if (!ListEquals.listEquals(signaturePropertyTypeChoice, _that.getSignaturePropertyTypeChoice())) return false;
			if (!Objects.equals(target, _that.getTarget())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (signaturePropertyTypeChoice != null ? signaturePropertyTypeChoice.hashCode() : 0);
			_result = 31 * _result + (target != null ? target.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignaturePropertyType {" +
				"signaturePropertyTypeChoice=" + this.signaturePropertyTypeChoice + ", " +
				"target=" + this.target + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of SignaturePropertyType  ***********************/
	class SignaturePropertyTypeBuilderImpl implements SignaturePropertyType.SignaturePropertyTypeBuilder {
	
		protected List<SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder> signaturePropertyTypeChoice = new ArrayList<>();
		protected String target;
		protected String id;
	
		public SignaturePropertyTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("signaturePropertyTypeChoice")
		public List<? extends SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder> getSignaturePropertyTypeChoice() {
			return signaturePropertyTypeChoice;
		}
		
		public SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder getOrCreateSignaturePropertyTypeChoice(int _index) {
		
			if (signaturePropertyTypeChoice==null) {
				this.signaturePropertyTypeChoice = new ArrayList<>();
			}
			SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder result;
			return getIndex(signaturePropertyTypeChoice, _index, () -> {
						SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder newSignaturePropertyTypeChoice = SignaturePropertyTypeChoice.builder();
						return newSignaturePropertyTypeChoice;
					});
		}
		
		@Override
		@RosettaAttribute("target")
		public String getTarget() {
			return target;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public SignaturePropertyType.SignaturePropertyTypeBuilder addSignaturePropertyTypeChoice(SignaturePropertyTypeChoice signaturePropertyTypeChoice) {
			if (signaturePropertyTypeChoice!=null) this.signaturePropertyTypeChoice.add(signaturePropertyTypeChoice.toBuilder());
			return this;
		}
		
		@Override
		public SignaturePropertyType.SignaturePropertyTypeBuilder addSignaturePropertyTypeChoice(SignaturePropertyTypeChoice signaturePropertyTypeChoice, int _idx) {
			getIndex(this.signaturePropertyTypeChoice, _idx, () -> signaturePropertyTypeChoice.toBuilder());
			return this;
		}
		@Override 
		public SignaturePropertyType.SignaturePropertyTypeBuilder addSignaturePropertyTypeChoice(List<? extends SignaturePropertyTypeChoice> signaturePropertyTypeChoices) {
			if (signaturePropertyTypeChoices != null) {
				for (SignaturePropertyTypeChoice toAdd : signaturePropertyTypeChoices) {
					this.signaturePropertyTypeChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("signaturePropertyTypeChoice")
		public SignaturePropertyType.SignaturePropertyTypeBuilder setSignaturePropertyTypeChoice(List<? extends SignaturePropertyTypeChoice> signaturePropertyTypeChoices) {
			if (signaturePropertyTypeChoices == null)  {
				this.signaturePropertyTypeChoice = new ArrayList<>();
			}
			else {
				this.signaturePropertyTypeChoice = signaturePropertyTypeChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("target")
		public SignaturePropertyType.SignaturePropertyTypeBuilder setTarget(String target) {
			this.target = target==null?null:target;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public SignaturePropertyType.SignaturePropertyTypeBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public SignaturePropertyType build() {
			return new SignaturePropertyType.SignaturePropertyTypeImpl(this);
		}
		
		@Override
		public SignaturePropertyType.SignaturePropertyTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignaturePropertyType.SignaturePropertyTypeBuilder prune() {
			signaturePropertyTypeChoice = signaturePropertyTypeChoice.stream().filter(b->b!=null).<SignaturePropertyTypeChoice.SignaturePropertyTypeChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSignaturePropertyTypeChoice()!=null && getSignaturePropertyTypeChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTarget()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignaturePropertyType.SignaturePropertyTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SignaturePropertyType.SignaturePropertyTypeBuilder o = (SignaturePropertyType.SignaturePropertyTypeBuilder) other;
			
			merger.mergeRosetta(getSignaturePropertyTypeChoice(), o.getSignaturePropertyTypeChoice(), this::getOrCreateSignaturePropertyTypeChoice);
			
			merger.mergeBasic(getTarget(), o.getTarget(), this::setTarget);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SignaturePropertyType _that = getType().cast(o);
		
			if (!ListEquals.listEquals(signaturePropertyTypeChoice, _that.getSignaturePropertyTypeChoice())) return false;
			if (!Objects.equals(target, _that.getTarget())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (signaturePropertyTypeChoice != null ? signaturePropertyTypeChoice.hashCode() : 0);
			_result = 31 * _result + (target != null ? target.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SignaturePropertyTypeBuilder {" +
				"signaturePropertyTypeChoice=" + this.signaturePropertyTypeChoice + ", " +
				"target=" + this.target + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
