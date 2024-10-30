package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.VersionedContractId;
import fpml.confirmation.validation.VersionedContractIdTypeFormatValidator;
import fpml.confirmation.validation.VersionedContractIdValidator;
import fpml.confirmation.validation.exists.VersionedContractIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=VersionedContractId.class)
public class VersionedContractIdMeta implements RosettaMetaData<VersionedContractId> {

	@Override
	public List<Validator<? super VersionedContractId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VersionedContractId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super VersionedContractId> validator() {
		return new VersionedContractIdValidator();
	}

	@Override
	public Validator<? super VersionedContractId> typeFormatValidator() {
		return new VersionedContractIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VersionedContractId, Set<String>> onlyExistsValidator() {
		return new VersionedContractIdOnlyExistsValidator();
	}
}
