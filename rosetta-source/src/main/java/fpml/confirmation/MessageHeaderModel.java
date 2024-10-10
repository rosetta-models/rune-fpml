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
import fpml.confirmation.ImplementationSpecification;
import fpml.confirmation.MessageAddress;
import fpml.confirmation.MessageHeaderModel;
import fpml.confirmation.MessageHeaderModel.MessageHeaderModelBuilder;
import fpml.confirmation.MessageHeaderModel.MessageHeaderModelBuilderImpl;
import fpml.confirmation.MessageHeaderModel.MessageHeaderModelImpl;
import fpml.confirmation.PartyMessageInformation;
import fpml.confirmation.SignatureType;
import fpml.confirmation.meta.MessageHeaderModelMeta;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines the structure that contains routing and identification information, which allows processing and transfer of the message. It contains only messaging information that is applicable to all messages. If the information is not message related or is not applicable to all messages then it is not defined in the message header.
 * @version ${project.version}
 */
@RosettaDataType(value="MessageHeaderModel", builder=MessageHeaderModel.MessageHeaderModelBuilderImpl.class, version="${project.version}")
public interface MessageHeaderModel extends RosettaModelObject {

	MessageHeaderModelMeta metaData = new MessageHeaderModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The unique identifier (within its coding scheme) for the originator of a message instance.
	 */
	MessageAddress getSentBy();
	/**
	 * A unique identifier (within its coding scheme) indicating an intended recipent of a message.
	 */
	List<? extends MessageAddress> getSendTo();
	/**
	 * A unique identifier (within the specified coding scheme) giving the details of some party to whom a copy of this message will be sent for reference.
	 */
	List<? extends MessageAddress> getCopyTo();
	/**
	 * The date and time (on the source system) when this message instance was created.
	 */
	ZonedDateTime getCreationTimestamp();
	/**
	 * The date and time (on the source system) when this message instance will be considered expired.
	 */
	ZonedDateTime getExpiryTimestamp();
	/**
	 * The version(s) of specifications that the sender asserts the message was developed for.
	 */
	ImplementationSpecification getImplementationSpecification();
	/**
	 * Additional message information that may be provided by each involved party.
	 */
	List<? extends PartyMessageInformation> getPartyMessageInformation();
	List<? extends SignatureType> getSignature();

	/*********************** Build Methods  ***********************/
	MessageHeaderModel build();
	
	MessageHeaderModel.MessageHeaderModelBuilder toBuilder();
	
	static MessageHeaderModel.MessageHeaderModelBuilder builder() {
		return new MessageHeaderModel.MessageHeaderModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MessageHeaderModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MessageHeaderModel> getType() {
		return MessageHeaderModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("sentBy"), processor, MessageAddress.class, getSentBy());
		processRosetta(path.newSubPath("sendTo"), processor, MessageAddress.class, getSendTo());
		processRosetta(path.newSubPath("copyTo"), processor, MessageAddress.class, getCopyTo());
		processor.processBasic(path.newSubPath("creationTimestamp"), ZonedDateTime.class, getCreationTimestamp(), this);
		processor.processBasic(path.newSubPath("expiryTimestamp"), ZonedDateTime.class, getExpiryTimestamp(), this);
		processRosetta(path.newSubPath("implementationSpecification"), processor, ImplementationSpecification.class, getImplementationSpecification());
		processRosetta(path.newSubPath("partyMessageInformation"), processor, PartyMessageInformation.class, getPartyMessageInformation());
		processRosetta(path.newSubPath("signature"), processor, SignatureType.class, getSignature());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MessageHeaderModelBuilder extends MessageHeaderModel, RosettaModelObjectBuilder {
		MessageAddress.MessageAddressBuilder getOrCreateSentBy();
		MessageAddress.MessageAddressBuilder getSentBy();
		MessageAddress.MessageAddressBuilder getOrCreateSendTo(int _index);
		List<? extends MessageAddress.MessageAddressBuilder> getSendTo();
		MessageAddress.MessageAddressBuilder getOrCreateCopyTo(int _index);
		List<? extends MessageAddress.MessageAddressBuilder> getCopyTo();
		ImplementationSpecification.ImplementationSpecificationBuilder getOrCreateImplementationSpecification();
		ImplementationSpecification.ImplementationSpecificationBuilder getImplementationSpecification();
		PartyMessageInformation.PartyMessageInformationBuilder getOrCreatePartyMessageInformation(int _index);
		List<? extends PartyMessageInformation.PartyMessageInformationBuilder> getPartyMessageInformation();
		SignatureType.SignatureTypeBuilder getOrCreateSignature(int _index);
		List<? extends SignatureType.SignatureTypeBuilder> getSignature();
		MessageHeaderModel.MessageHeaderModelBuilder setSentBy(MessageAddress sentBy);
		MessageHeaderModel.MessageHeaderModelBuilder addSendTo(MessageAddress sendTo0);
		MessageHeaderModel.MessageHeaderModelBuilder addSendTo(MessageAddress sendTo1, int _idx);
		MessageHeaderModel.MessageHeaderModelBuilder addSendTo(List<? extends MessageAddress> sendTo2);
		MessageHeaderModel.MessageHeaderModelBuilder setSendTo(List<? extends MessageAddress> sendTo3);
		MessageHeaderModel.MessageHeaderModelBuilder addCopyTo(MessageAddress copyTo0);
		MessageHeaderModel.MessageHeaderModelBuilder addCopyTo(MessageAddress copyTo1, int _idx);
		MessageHeaderModel.MessageHeaderModelBuilder addCopyTo(List<? extends MessageAddress> copyTo2);
		MessageHeaderModel.MessageHeaderModelBuilder setCopyTo(List<? extends MessageAddress> copyTo3);
		MessageHeaderModel.MessageHeaderModelBuilder setCreationTimestamp(ZonedDateTime creationTimestamp);
		MessageHeaderModel.MessageHeaderModelBuilder setExpiryTimestamp(ZonedDateTime expiryTimestamp);
		MessageHeaderModel.MessageHeaderModelBuilder setImplementationSpecification(ImplementationSpecification implementationSpecification);
		MessageHeaderModel.MessageHeaderModelBuilder addPartyMessageInformation(PartyMessageInformation partyMessageInformation0);
		MessageHeaderModel.MessageHeaderModelBuilder addPartyMessageInformation(PartyMessageInformation partyMessageInformation1, int _idx);
		MessageHeaderModel.MessageHeaderModelBuilder addPartyMessageInformation(List<? extends PartyMessageInformation> partyMessageInformation2);
		MessageHeaderModel.MessageHeaderModelBuilder setPartyMessageInformation(List<? extends PartyMessageInformation> partyMessageInformation3);
		MessageHeaderModel.MessageHeaderModelBuilder addSignature(SignatureType signature0);
		MessageHeaderModel.MessageHeaderModelBuilder addSignature(SignatureType signature1, int _idx);
		MessageHeaderModel.MessageHeaderModelBuilder addSignature(List<? extends SignatureType> signature2);
		MessageHeaderModel.MessageHeaderModelBuilder setSignature(List<? extends SignatureType> signature3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("sentBy"), processor, MessageAddress.MessageAddressBuilder.class, getSentBy());
			processRosetta(path.newSubPath("sendTo"), processor, MessageAddress.MessageAddressBuilder.class, getSendTo());
			processRosetta(path.newSubPath("copyTo"), processor, MessageAddress.MessageAddressBuilder.class, getCopyTo());
			processor.processBasic(path.newSubPath("creationTimestamp"), ZonedDateTime.class, getCreationTimestamp(), this);
			processor.processBasic(path.newSubPath("expiryTimestamp"), ZonedDateTime.class, getExpiryTimestamp(), this);
			processRosetta(path.newSubPath("implementationSpecification"), processor, ImplementationSpecification.ImplementationSpecificationBuilder.class, getImplementationSpecification());
			processRosetta(path.newSubPath("partyMessageInformation"), processor, PartyMessageInformation.PartyMessageInformationBuilder.class, getPartyMessageInformation());
			processRosetta(path.newSubPath("signature"), processor, SignatureType.SignatureTypeBuilder.class, getSignature());
		}
		

		MessageHeaderModel.MessageHeaderModelBuilder prune();
	}

	/*********************** Immutable Implementation of MessageHeaderModel  ***********************/
	class MessageHeaderModelImpl implements MessageHeaderModel {
		private final MessageAddress sentBy;
		private final List<? extends MessageAddress> sendTo;
		private final List<? extends MessageAddress> copyTo;
		private final ZonedDateTime creationTimestamp;
		private final ZonedDateTime expiryTimestamp;
		private final ImplementationSpecification implementationSpecification;
		private final List<? extends PartyMessageInformation> partyMessageInformation;
		private final List<? extends SignatureType> signature;
		
		protected MessageHeaderModelImpl(MessageHeaderModel.MessageHeaderModelBuilder builder) {
			this.sentBy = ofNullable(builder.getSentBy()).map(f->f.build()).orElse(null);
			this.sendTo = ofNullable(builder.getSendTo()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.copyTo = ofNullable(builder.getCopyTo()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.creationTimestamp = builder.getCreationTimestamp();
			this.expiryTimestamp = builder.getExpiryTimestamp();
			this.implementationSpecification = ofNullable(builder.getImplementationSpecification()).map(f->f.build()).orElse(null);
			this.partyMessageInformation = ofNullable(builder.getPartyMessageInformation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.signature = ofNullable(builder.getSignature()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("sentBy")
		public MessageAddress getSentBy() {
			return sentBy;
		}
		
		@Override
		@RosettaAttribute("sendTo")
		public List<? extends MessageAddress> getSendTo() {
			return sendTo;
		}
		
		@Override
		@RosettaAttribute("copyTo")
		public List<? extends MessageAddress> getCopyTo() {
			return copyTo;
		}
		
		@Override
		@RosettaAttribute("creationTimestamp")
		public ZonedDateTime getCreationTimestamp() {
			return creationTimestamp;
		}
		
		@Override
		@RosettaAttribute("expiryTimestamp")
		public ZonedDateTime getExpiryTimestamp() {
			return expiryTimestamp;
		}
		
		@Override
		@RosettaAttribute("implementationSpecification")
		public ImplementationSpecification getImplementationSpecification() {
			return implementationSpecification;
		}
		
		@Override
		@RosettaAttribute("partyMessageInformation")
		public List<? extends PartyMessageInformation> getPartyMessageInformation() {
			return partyMessageInformation;
		}
		
		@Override
		@RosettaAttribute("signature")
		public List<? extends SignatureType> getSignature() {
			return signature;
		}
		
		@Override
		public MessageHeaderModel build() {
			return this;
		}
		
		@Override
		public MessageHeaderModel.MessageHeaderModelBuilder toBuilder() {
			MessageHeaderModel.MessageHeaderModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MessageHeaderModel.MessageHeaderModelBuilder builder) {
			ofNullable(getSentBy()).ifPresent(builder::setSentBy);
			ofNullable(getSendTo()).ifPresent(builder::setSendTo);
			ofNullable(getCopyTo()).ifPresent(builder::setCopyTo);
			ofNullable(getCreationTimestamp()).ifPresent(builder::setCreationTimestamp);
			ofNullable(getExpiryTimestamp()).ifPresent(builder::setExpiryTimestamp);
			ofNullable(getImplementationSpecification()).ifPresent(builder::setImplementationSpecification);
			ofNullable(getPartyMessageInformation()).ifPresent(builder::setPartyMessageInformation);
			ofNullable(getSignature()).ifPresent(builder::setSignature);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MessageHeaderModel _that = getType().cast(o);
		
			if (!Objects.equals(sentBy, _that.getSentBy())) return false;
			if (!ListEquals.listEquals(sendTo, _that.getSendTo())) return false;
			if (!ListEquals.listEquals(copyTo, _that.getCopyTo())) return false;
			if (!Objects.equals(creationTimestamp, _that.getCreationTimestamp())) return false;
			if (!Objects.equals(expiryTimestamp, _that.getExpiryTimestamp())) return false;
			if (!Objects.equals(implementationSpecification, _that.getImplementationSpecification())) return false;
			if (!ListEquals.listEquals(partyMessageInformation, _that.getPartyMessageInformation())) return false;
			if (!ListEquals.listEquals(signature, _that.getSignature())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sentBy != null ? sentBy.hashCode() : 0);
			_result = 31 * _result + (sendTo != null ? sendTo.hashCode() : 0);
			_result = 31 * _result + (copyTo != null ? copyTo.hashCode() : 0);
			_result = 31 * _result + (creationTimestamp != null ? creationTimestamp.hashCode() : 0);
			_result = 31 * _result + (expiryTimestamp != null ? expiryTimestamp.hashCode() : 0);
			_result = 31 * _result + (implementationSpecification != null ? implementationSpecification.hashCode() : 0);
			_result = 31 * _result + (partyMessageInformation != null ? partyMessageInformation.hashCode() : 0);
			_result = 31 * _result + (signature != null ? signature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MessageHeaderModel {" +
				"sentBy=" + this.sentBy + ", " +
				"sendTo=" + this.sendTo + ", " +
				"copyTo=" + this.copyTo + ", " +
				"creationTimestamp=" + this.creationTimestamp + ", " +
				"expiryTimestamp=" + this.expiryTimestamp + ", " +
				"implementationSpecification=" + this.implementationSpecification + ", " +
				"partyMessageInformation=" + this.partyMessageInformation + ", " +
				"signature=" + this.signature +
			'}';
		}
	}

	/*********************** Builder Implementation of MessageHeaderModel  ***********************/
	class MessageHeaderModelBuilderImpl implements MessageHeaderModel.MessageHeaderModelBuilder {
	
		protected MessageAddress.MessageAddressBuilder sentBy;
		protected List<MessageAddress.MessageAddressBuilder> sendTo = new ArrayList<>();
		protected List<MessageAddress.MessageAddressBuilder> copyTo = new ArrayList<>();
		protected ZonedDateTime creationTimestamp;
		protected ZonedDateTime expiryTimestamp;
		protected ImplementationSpecification.ImplementationSpecificationBuilder implementationSpecification;
		protected List<PartyMessageInformation.PartyMessageInformationBuilder> partyMessageInformation = new ArrayList<>();
		protected List<SignatureType.SignatureTypeBuilder> signature = new ArrayList<>();
	
		public MessageHeaderModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("sentBy")
		public MessageAddress.MessageAddressBuilder getSentBy() {
			return sentBy;
		}
		
		@Override
		public MessageAddress.MessageAddressBuilder getOrCreateSentBy() {
			MessageAddress.MessageAddressBuilder result;
			if (sentBy!=null) {
				result = sentBy;
			}
			else {
				result = sentBy = MessageAddress.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sendTo")
		public List<? extends MessageAddress.MessageAddressBuilder> getSendTo() {
			return sendTo;
		}
		
		public MessageAddress.MessageAddressBuilder getOrCreateSendTo(int _index) {
		
			if (sendTo==null) {
				this.sendTo = new ArrayList<>();
			}
			MessageAddress.MessageAddressBuilder result;
			return getIndex(sendTo, _index, () -> {
						MessageAddress.MessageAddressBuilder newSendTo = MessageAddress.builder();
						return newSendTo;
					});
		}
		
		@Override
		@RosettaAttribute("copyTo")
		public List<? extends MessageAddress.MessageAddressBuilder> getCopyTo() {
			return copyTo;
		}
		
		public MessageAddress.MessageAddressBuilder getOrCreateCopyTo(int _index) {
		
			if (copyTo==null) {
				this.copyTo = new ArrayList<>();
			}
			MessageAddress.MessageAddressBuilder result;
			return getIndex(copyTo, _index, () -> {
						MessageAddress.MessageAddressBuilder newCopyTo = MessageAddress.builder();
						return newCopyTo;
					});
		}
		
		@Override
		@RosettaAttribute("creationTimestamp")
		public ZonedDateTime getCreationTimestamp() {
			return creationTimestamp;
		}
		
		@Override
		@RosettaAttribute("expiryTimestamp")
		public ZonedDateTime getExpiryTimestamp() {
			return expiryTimestamp;
		}
		
		@Override
		@RosettaAttribute("implementationSpecification")
		public ImplementationSpecification.ImplementationSpecificationBuilder getImplementationSpecification() {
			return implementationSpecification;
		}
		
		@Override
		public ImplementationSpecification.ImplementationSpecificationBuilder getOrCreateImplementationSpecification() {
			ImplementationSpecification.ImplementationSpecificationBuilder result;
			if (implementationSpecification!=null) {
				result = implementationSpecification;
			}
			else {
				result = implementationSpecification = ImplementationSpecification.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyMessageInformation")
		public List<? extends PartyMessageInformation.PartyMessageInformationBuilder> getPartyMessageInformation() {
			return partyMessageInformation;
		}
		
		public PartyMessageInformation.PartyMessageInformationBuilder getOrCreatePartyMessageInformation(int _index) {
		
			if (partyMessageInformation==null) {
				this.partyMessageInformation = new ArrayList<>();
			}
			PartyMessageInformation.PartyMessageInformationBuilder result;
			return getIndex(partyMessageInformation, _index, () -> {
						PartyMessageInformation.PartyMessageInformationBuilder newPartyMessageInformation = PartyMessageInformation.builder();
						return newPartyMessageInformation;
					});
		}
		
		@Override
		@RosettaAttribute("signature")
		public List<? extends SignatureType.SignatureTypeBuilder> getSignature() {
			return signature;
		}
		
		public SignatureType.SignatureTypeBuilder getOrCreateSignature(int _index) {
		
			if (signature==null) {
				this.signature = new ArrayList<>();
			}
			SignatureType.SignatureTypeBuilder result;
			return getIndex(signature, _index, () -> {
						SignatureType.SignatureTypeBuilder newSignature = SignatureType.builder();
						return newSignature;
					});
		}
		
		@Override
		@RosettaAttribute("sentBy")
		public MessageHeaderModel.MessageHeaderModelBuilder setSentBy(MessageAddress sentBy) {
			this.sentBy = sentBy==null?null:sentBy.toBuilder();
			return this;
		}
		@Override
		public MessageHeaderModel.MessageHeaderModelBuilder addSendTo(MessageAddress sendTo) {
			if (sendTo!=null) this.sendTo.add(sendTo.toBuilder());
			return this;
		}
		
		@Override
		public MessageHeaderModel.MessageHeaderModelBuilder addSendTo(MessageAddress sendTo, int _idx) {
			getIndex(this.sendTo, _idx, () -> sendTo.toBuilder());
			return this;
		}
		@Override 
		public MessageHeaderModel.MessageHeaderModelBuilder addSendTo(List<? extends MessageAddress> sendTos) {
			if (sendTos != null) {
				for (MessageAddress toAdd : sendTos) {
					this.sendTo.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("sendTo")
		public MessageHeaderModel.MessageHeaderModelBuilder setSendTo(List<? extends MessageAddress> sendTos) {
			if (sendTos == null)  {
				this.sendTo = new ArrayList<>();
			}
			else {
				this.sendTo = sendTos.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public MessageHeaderModel.MessageHeaderModelBuilder addCopyTo(MessageAddress copyTo) {
			if (copyTo!=null) this.copyTo.add(copyTo.toBuilder());
			return this;
		}
		
		@Override
		public MessageHeaderModel.MessageHeaderModelBuilder addCopyTo(MessageAddress copyTo, int _idx) {
			getIndex(this.copyTo, _idx, () -> copyTo.toBuilder());
			return this;
		}
		@Override 
		public MessageHeaderModel.MessageHeaderModelBuilder addCopyTo(List<? extends MessageAddress> copyTos) {
			if (copyTos != null) {
				for (MessageAddress toAdd : copyTos) {
					this.copyTo.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("copyTo")
		public MessageHeaderModel.MessageHeaderModelBuilder setCopyTo(List<? extends MessageAddress> copyTos) {
			if (copyTos == null)  {
				this.copyTo = new ArrayList<>();
			}
			else {
				this.copyTo = copyTos.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("creationTimestamp")
		public MessageHeaderModel.MessageHeaderModelBuilder setCreationTimestamp(ZonedDateTime creationTimestamp) {
			this.creationTimestamp = creationTimestamp==null?null:creationTimestamp;
			return this;
		}
		@Override
		@RosettaAttribute("expiryTimestamp")
		public MessageHeaderModel.MessageHeaderModelBuilder setExpiryTimestamp(ZonedDateTime expiryTimestamp) {
			this.expiryTimestamp = expiryTimestamp==null?null:expiryTimestamp;
			return this;
		}
		@Override
		@RosettaAttribute("implementationSpecification")
		public MessageHeaderModel.MessageHeaderModelBuilder setImplementationSpecification(ImplementationSpecification implementationSpecification) {
			this.implementationSpecification = implementationSpecification==null?null:implementationSpecification.toBuilder();
			return this;
		}
		@Override
		public MessageHeaderModel.MessageHeaderModelBuilder addPartyMessageInformation(PartyMessageInformation partyMessageInformation) {
			if (partyMessageInformation!=null) this.partyMessageInformation.add(partyMessageInformation.toBuilder());
			return this;
		}
		
		@Override
		public MessageHeaderModel.MessageHeaderModelBuilder addPartyMessageInformation(PartyMessageInformation partyMessageInformation, int _idx) {
			getIndex(this.partyMessageInformation, _idx, () -> partyMessageInformation.toBuilder());
			return this;
		}
		@Override 
		public MessageHeaderModel.MessageHeaderModelBuilder addPartyMessageInformation(List<? extends PartyMessageInformation> partyMessageInformations) {
			if (partyMessageInformations != null) {
				for (PartyMessageInformation toAdd : partyMessageInformations) {
					this.partyMessageInformation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("partyMessageInformation")
		public MessageHeaderModel.MessageHeaderModelBuilder setPartyMessageInformation(List<? extends PartyMessageInformation> partyMessageInformations) {
			if (partyMessageInformations == null)  {
				this.partyMessageInformation = new ArrayList<>();
			}
			else {
				this.partyMessageInformation = partyMessageInformations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public MessageHeaderModel.MessageHeaderModelBuilder addSignature(SignatureType signature) {
			if (signature!=null) this.signature.add(signature.toBuilder());
			return this;
		}
		
		@Override
		public MessageHeaderModel.MessageHeaderModelBuilder addSignature(SignatureType signature, int _idx) {
			getIndex(this.signature, _idx, () -> signature.toBuilder());
			return this;
		}
		@Override 
		public MessageHeaderModel.MessageHeaderModelBuilder addSignature(List<? extends SignatureType> signatures) {
			if (signatures != null) {
				for (SignatureType toAdd : signatures) {
					this.signature.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("signature")
		public MessageHeaderModel.MessageHeaderModelBuilder setSignature(List<? extends SignatureType> signatures) {
			if (signatures == null)  {
				this.signature = new ArrayList<>();
			}
			else {
				this.signature = signatures.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public MessageHeaderModel build() {
			return new MessageHeaderModel.MessageHeaderModelImpl(this);
		}
		
		@Override
		public MessageHeaderModel.MessageHeaderModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MessageHeaderModel.MessageHeaderModelBuilder prune() {
			if (sentBy!=null && !sentBy.prune().hasData()) sentBy = null;
			sendTo = sendTo.stream().filter(b->b!=null).<MessageAddress.MessageAddressBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			copyTo = copyTo.stream().filter(b->b!=null).<MessageAddress.MessageAddressBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (implementationSpecification!=null && !implementationSpecification.prune().hasData()) implementationSpecification = null;
			partyMessageInformation = partyMessageInformation.stream().filter(b->b!=null).<PartyMessageInformation.PartyMessageInformationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			signature = signature.stream().filter(b->b!=null).<SignatureType.SignatureTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSentBy()!=null && getSentBy().hasData()) return true;
			if (getSendTo()!=null && getSendTo().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCopyTo()!=null && getCopyTo().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCreationTimestamp()!=null) return true;
			if (getExpiryTimestamp()!=null) return true;
			if (getImplementationSpecification()!=null && getImplementationSpecification().hasData()) return true;
			if (getPartyMessageInformation()!=null && getPartyMessageInformation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSignature()!=null && getSignature().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MessageHeaderModel.MessageHeaderModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MessageHeaderModel.MessageHeaderModelBuilder o = (MessageHeaderModel.MessageHeaderModelBuilder) other;
			
			merger.mergeRosetta(getSentBy(), o.getSentBy(), this::setSentBy);
			merger.mergeRosetta(getSendTo(), o.getSendTo(), this::getOrCreateSendTo);
			merger.mergeRosetta(getCopyTo(), o.getCopyTo(), this::getOrCreateCopyTo);
			merger.mergeRosetta(getImplementationSpecification(), o.getImplementationSpecification(), this::setImplementationSpecification);
			merger.mergeRosetta(getPartyMessageInformation(), o.getPartyMessageInformation(), this::getOrCreatePartyMessageInformation);
			merger.mergeRosetta(getSignature(), o.getSignature(), this::getOrCreateSignature);
			
			merger.mergeBasic(getCreationTimestamp(), o.getCreationTimestamp(), this::setCreationTimestamp);
			merger.mergeBasic(getExpiryTimestamp(), o.getExpiryTimestamp(), this::setExpiryTimestamp);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MessageHeaderModel _that = getType().cast(o);
		
			if (!Objects.equals(sentBy, _that.getSentBy())) return false;
			if (!ListEquals.listEquals(sendTo, _that.getSendTo())) return false;
			if (!ListEquals.listEquals(copyTo, _that.getCopyTo())) return false;
			if (!Objects.equals(creationTimestamp, _that.getCreationTimestamp())) return false;
			if (!Objects.equals(expiryTimestamp, _that.getExpiryTimestamp())) return false;
			if (!Objects.equals(implementationSpecification, _that.getImplementationSpecification())) return false;
			if (!ListEquals.listEquals(partyMessageInformation, _that.getPartyMessageInformation())) return false;
			if (!ListEquals.listEquals(signature, _that.getSignature())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sentBy != null ? sentBy.hashCode() : 0);
			_result = 31 * _result + (sendTo != null ? sendTo.hashCode() : 0);
			_result = 31 * _result + (copyTo != null ? copyTo.hashCode() : 0);
			_result = 31 * _result + (creationTimestamp != null ? creationTimestamp.hashCode() : 0);
			_result = 31 * _result + (expiryTimestamp != null ? expiryTimestamp.hashCode() : 0);
			_result = 31 * _result + (implementationSpecification != null ? implementationSpecification.hashCode() : 0);
			_result = 31 * _result + (partyMessageInformation != null ? partyMessageInformation.hashCode() : 0);
			_result = 31 * _result + (signature != null ? signature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MessageHeaderModelBuilder {" +
				"sentBy=" + this.sentBy + ", " +
				"sendTo=" + this.sendTo + ", " +
				"copyTo=" + this.copyTo + ", " +
				"creationTimestamp=" + this.creationTimestamp + ", " +
				"expiryTimestamp=" + this.expiryTimestamp + ", " +
				"implementationSpecification=" + this.implementationSpecification + ", " +
				"partyMessageInformation=" + this.partyMessageInformation + ", " +
				"signature=" + this.signature +
			'}';
		}
	}
}
