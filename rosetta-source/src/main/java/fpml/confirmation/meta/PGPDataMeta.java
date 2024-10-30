package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PGPData;
import fpml.confirmation.validation.PGPDataTypeFormatValidator;
import fpml.confirmation.validation.PGPDataValidator;
import fpml.confirmation.validation.exists.PGPDataOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PGPData.class)
public class PGPDataMeta implements RosettaMetaData<PGPData> {

	@Override
	public List<Validator<? super PGPData>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.PGPDataType>create(fpml.confirmation.validation.datarule.PGPDataTypeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PGPData, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PGPData> validator() {
		return new PGPDataValidator();
	}

	@Override
	public Validator<? super PGPData> typeFormatValidator() {
		return new PGPDataTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PGPData, Set<String>> onlyExistsValidator() {
		return new PGPDataOnlyExistsValidator();
	}
}
