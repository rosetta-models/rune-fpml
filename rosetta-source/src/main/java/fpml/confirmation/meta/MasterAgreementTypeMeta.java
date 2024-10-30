package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MasterAgreementType;
import fpml.confirmation.validation.MasterAgreementTypeTypeFormatValidator;
import fpml.confirmation.validation.MasterAgreementTypeValidator;
import fpml.confirmation.validation.exists.MasterAgreementTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=MasterAgreementType.class)
public class MasterAgreementTypeMeta implements RosettaMetaData<MasterAgreementType> {

	@Override
	public List<Validator<? super MasterAgreementType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MasterAgreementType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MasterAgreementType> validator() {
		return new MasterAgreementTypeValidator();
	}

	@Override
	public Validator<? super MasterAgreementType> typeFormatValidator() {
		return new MasterAgreementTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MasterAgreementType, Set<String>> onlyExistsValidator() {
		return new MasterAgreementTypeOnlyExistsValidator();
	}
}
